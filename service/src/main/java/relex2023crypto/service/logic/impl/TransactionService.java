package relex2023crypto.service.logic.impl;

import org.springframework.stereotype.Service;
import relex2023crypto.service.logic.ITransactionService;
import relex2023crypto.service.model.TransactionDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Override
    public WalletDto cashOut(Integer requestingUserId, TransactionDto dto) {
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
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactions(Integer requestingUserId) {
        return null;
    }
}
