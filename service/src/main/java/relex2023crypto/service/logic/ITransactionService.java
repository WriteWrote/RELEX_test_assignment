package relex2023crypto.service.logic;

import relex2023crypto.service.model.ResponseDto;
import relex2023crypto.service.model.TransactionDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

public interface ITransactionService {
    ResponseDto cashOut(Integer requestingUserId, TransactionDto dto);

    ResponseDto cashIn(Integer requestingUserId, TransactionDto dto);

    ResponseDto cashExchange(Integer requestingUserId,
                             TransactionDto exchangeFrom,
                             TransactionDto exchangeTo);

    List<TransactionDto> getUserTransactionHistory(Integer requestingUserId, Integer userId);

    List<TransactionDto> getAllTransactions(Integer requestingUserId);

}
