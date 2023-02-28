package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.entities.WalletEntity;
import relex2023crypto.db.repositories.ExchangeRateRepository;
import relex2023crypto.db.repositories.TransactionRepository;
import relex2023crypto.db.repositories.WalletRepository;
import relex2023crypto.service.logic.ITransactionService;
import relex2023crypto.service.logic.utils.AdminAccessProvider;
import relex2023crypto.service.mapper.ITransactionMapper;
import relex2023crypto.service.mapper.IWalletMapper;
import relex2023crypto.service.model.responses.ExchangeResponseDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.TransactionDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final AdminAccessProvider provider;
    private final TransactionRepository transactionRepository;
    private final ITransactionMapper transactionMapper;
    private final WalletRepository walletRepository;
    private final IWalletMapper walletMapper;

    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public TransactionService(AdminAccessProvider provider,
                              TransactionRepository transactionRepository,
                              WalletRepository walletRepository,
                              ITransactionMapper transactionMapper,
                              IWalletMapper walletMapper,
                              ExchangeRateRepository exchangeRateRepository) {
        this.provider = provider;
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.transactionMapper = transactionMapper;
        this.walletMapper = walletMapper;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    private ResponseDto<WalletDto> cashOut(TransactionDto dto) {
        WalletDto newWallet = walletMapper.fromEntity(walletRepository.getById(dto.getWalletId()));

        if (newWallet.getSum() >= dto.getSum()) {
            logger.info("Operation succeeded");
            Double newSum = newWallet.getSum() - dto.getSum();
            newWallet.setSum(newSum);
        } else {
            logger.info("Operation denied due to lack of cash on the wallet");
            return new ResponseDto<WalletDto>("Operation denied due to lack of cash on the wallet {}",
                    false,
                    newWallet);
        }

        WalletEntity newEntity = walletMapper.merge(newWallet, walletRepository.getById(dto.getWalletId()));
        walletRepository.save(newEntity);

        return new ResponseDto<WalletDto>("Operation succeeded", newWallet);
    }

    private ResponseDto<WalletDto> cashIn(TransactionDto dto) {
        WalletDto newWallet = walletMapper.fromEntity(walletRepository.getById(dto.getWalletId()));

        logger.info("Operation succeeded");
        Double newSum = newWallet.getSum() + dto.getSum();
        newWallet.setSum(newSum);

        WalletEntity newEntity = walletMapper.merge(newWallet, walletRepository.getById(dto.getWalletId()));
        walletRepository.save(newEntity);

        return new ResponseDto<WalletDto>("Operation succeeded", newWallet);
    }

    @Override
    public ResponseDto<WalletDto> cashOut(Integer requestingUserId, TransactionDto dto) {
        logger.info("Requested cash out by user {}, wallet {}, currency{}, sum {}, access{}",
                requestingUserId, dto.getWalletId(), dto.getCurrencyId(), dto.getSum(), "access");

        ResponseDto<WalletDto> response = cashOut(dto);

        if (!response.getSuccess()) {
            dto.setMessage("denied");
        }

        transactionRepository.save(transactionMapper.toEntity(dto));

        return response;
    }

    @Override
    public ResponseDto<WalletDto> cashIn(Integer requestingUserId, TransactionDto dto) {
        logger.info("Requested cash in by user {}, wallet {}, currency{}, sum {}, access{}",
                requestingUserId, dto.getWalletId(), dto.getCurrencyId(), dto.getSum(), "access");

        ResponseDto<WalletDto> response = cashIn(dto);

        transactionRepository.save(transactionMapper.toEntity(dto));

        return response;
    }

    @Override
    public ResponseDto<ExchangeResponseDto> cashExchange(Integer requestingUserId,
                                                         TransactionDto exchangeFrom,
                                                         TransactionDto exchangeTo) {
        logger.info("Requested cash exchange by user {}, wallet from {}, currency from{}, sum {}" +
                        "wallet to {}, currency to {}, access{}",
                requestingUserId,
                exchangeFrom.getWalletId(), exchangeFrom.getCurrencyId(),
                exchangeFrom.getSum(),
                exchangeTo.getWalletId(), exchangeTo.getCurrencyId(),
                "access");

        ResponseDto<WalletDto> responseCashOut = cashOut(exchangeFrom);
        ResponseDto<WalletDto> responseCashIn = new ResponseDto<>("suspended");

        if (responseCashOut.getSuccess()) {
            Double coef = exchangeRateRepository.findByCurrencyFromAndCurrencyTo(exchangeFrom.getCurrencyId(),
                            exchangeTo.getCurrencyId())
                    .getCoef();
            Double exchangedSum = exchangeFrom.getSum() * coef;
            exchangeTo.setSum(exchangedSum);
            responseCashIn = cashIn(exchangeTo);
        } else {
            exchangeFrom.setMessage("denied");
            exchangeTo.setMessage("denied");
        }

        transactionRepository.save(transactionMapper.toEntity(exchangeFrom));
        transactionRepository.save(transactionMapper.toEntity(exchangeTo));

        //todo: add transaction which gets transaction count from date to date
        var responseArgs = new ExchangeResponseDto(responseCashOut.getArgs()[0].getCurrencyId(),
                responseCashOut.getArgs()[0].getSum(),
                responseCashIn.getArgs()[0].getCurrencyId(),
                responseCashIn.getArgs()[0].getSum(),
                exchangeTo.getDate());

        return new ResponseDto<ExchangeResponseDto>(responseCashOut.getMessage() + "\n"
                + responseArgs);
    }

    @Override
    public ResponseDto<List<TransactionDto>> getUserTransactionHistory(Integer requestingUserId, Integer userId) {
        Boolean access = provider.checkAdminAccessByUserId(requestingUserId);
        logger.info("Requested user {} transaction history by user {}, access {}",
                userId, requestingUserId, access);

        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins or user itself");
        }

        return new ResponseDto<>("Operation succeded",
                Optional.of(transactionRepository.findAllByUserId(userId))
                        .map(transactionMapper::fromEntities)
                        .orElseThrow());

    }

    @Override
    public ResponseDto<List<TransactionDto>> getAllTransactions(Integer requestingUserId) {
        Boolean access = provider.checkAdminAccessByUserId(requestingUserId);
        logger.info("Requested all transactions by user {}, access: {}",
                requestingUserId, access);

        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins");
        }

        return new ResponseDto<>("Operation succeeded",
                Optional.of(transactionRepository.findAll())
                        .map(transactionMapper::fromEntities)
                        .orElseThrow());
    }
}
