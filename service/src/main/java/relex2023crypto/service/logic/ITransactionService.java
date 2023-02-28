package relex2023crypto.service.logic;

import relex2023crypto.service.model.WalletDto;
import relex2023crypto.service.model.responses.ExchangeResponseDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.TransactionDto;

import java.util.List;

public interface ITransactionService {
    ResponseDto<WalletDto> cashOut(Integer requestingUserId, TransactionDto dto);

    ResponseDto<WalletDto> cashIn(Integer requestingUserId, TransactionDto dto);

    ResponseDto<ExchangeResponseDto> cashExchange(Integer requestingUserId,
                                                  TransactionDto exchangeFrom,
                                                  TransactionDto exchangeTo);

    ResponseDto<List<TransactionDto>> getUserTransactionHistory(Integer requestingUserId, Integer userId);

    ResponseDto<List<TransactionDto>> getAllTransactions(Integer requestingUserId);

//    ResponseDto<List<TransactionDto>> getTransactionsInDateGap();

}
