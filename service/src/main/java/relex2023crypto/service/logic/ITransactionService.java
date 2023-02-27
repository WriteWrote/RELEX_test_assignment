package relex2023crypto.service.logic;

import relex2023crypto.service.model.TransactionDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

public interface ITransactionService {
    WalletDto cashOut(Integer requestingUserId, TransactionDto dto);

    WalletDto cashIn(Integer requestingUserId, TransactionDto dto);

    WalletDto cashExchange(Integer requestingUserId, TransactionDto dto);

    List<TransactionDto> getUserTransactionHistory(Integer requestingUserId, Integer userId);

    List<TransactionDto> getAllTransactions(Integer requestingUserId);

}
