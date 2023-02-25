package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.ITransactionService;
import relex2023crypto.service.model.TransactionDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash")
public class TransactionController {
    private final ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/out")
    public WalletDto cashOut(@PathVariable Integer requestingUserId,
                             @RequestBody TransactionDto transactionDto){
        return transactionService.cashOut(requestingUserId, transactionDto);
    }

    @PostMapping("/in")
    public WalletDto cashIn(@PathVariable Integer requestingUserId,
                            @RequestBody TransactionDto transactionDto){
        return transactionService.cashIn(requestingUserId, transactionDto);
    }

    @PostMapping("/exchange")
    public WalletDto cashExchange(@PathVariable Integer requestingUserId,
                                  @RequestBody TransactionDto transactionDto){
        return transactionService.cashExchange(requestingUserId, transactionDto)
    }

    @GetMapping("/transactions")
    public List<TransactionDto> getUserTransactionHistory(@PathVariable Integer requestingUserId){
        return transactionService.getUserTransactionHistory(requestingUserId);
    }

    @GetMapping("/transactions/all")
    public List<TransactionDto> getAllUsersTransactionHistory(@PathVariable Integer requestingUserId){
        return transactionService.getAllTransactions(requestingUserId);
    }
}
