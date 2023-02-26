package relex2023crypto.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.TransactionRepository;
import relex2023crypto.service.logic.ITransactionService;
import relex2023crypto.service.mapper.ITransactionMapper;
import relex2023crypto.service.model.TransactionDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository rep;
    private final ITransactionMapper map;

    @Autowired
    public TransactionService(TransactionRepository rep, ITransactionMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public WalletDto cashOut(Integer requestingUserId, TransactionDto dto) {
        logger.info("Requested cash out by user {}, wallet {}, currency{}, sum {}, access{}",
                requestingUserId, "wallet", dto.getCurrencyId(), dto.getSum(), "access");
        //todo: finish with merge
        return null;
    }

    @Override
    public WalletDto cashIn(Integer requestingUserId, TransactionDto dto) {

        return null;
    }

    @Override
    public WalletDto cashExchange(Integer requestingUserId, TransactionDto dto) {
        return null;
    }

    @Override
    public List<TransactionDto> getUserTransactionHistory(Integer requestingUserId) {
        logger.info("Requested user {} transaction history by user {}, access: {}",
                requestingUserId, "user", "access");
        //todo: add userid in the path and as parameter
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactions(Integer requestingUserId) {
        logger.info("Requested all transactions by user {}, access: {}",
                requestingUserId, "access");
        return null;
    }
}
