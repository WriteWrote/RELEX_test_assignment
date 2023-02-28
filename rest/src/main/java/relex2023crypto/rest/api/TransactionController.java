package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.ITransactionService;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.TransactionDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash/transactions")
public class TransactionController {
    private final ITransactionService transactionService;

    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/out")
    public ResponseDto cashOut(@PathVariable Integer requestingUserId,
                             @RequestBody TransactionDto transactionDto){
        return transactionService.cashOut(requestingUserId, transactionDto);
    }

    @PostMapping("/in")
    public ResponseDto cashIn(@PathVariable Integer requestingUserId,
                            @RequestBody TransactionDto transactionDto){
        return transactionService.cashIn(requestingUserId, transactionDto);
    }

    @PostMapping("/exchange")
    public ResponseDto cashExchange(@PathVariable Integer requestingUserId,
                                    @RequestBody TransactionDto exchangeFrom,
                                    @RequestBody TransactionDto exchangeTo){
        return transactionService.cashExchange(requestingUserId, exchangeFrom, exchangeTo);
    }

    @GetMapping("/{userId}")
    public List<TransactionDto> getUserTransactionHistory(@PathVariable Integer requestingUserId,
                                                          @PathVariable Integer userId){
        return transactionService.getUserTransactionHistory(requestingUserId, userId);
    }

    @GetMapping("/all")
    public List<TransactionDto> getAllUsersTransactionHistory(@PathVariable Integer requestingUserId){
        return transactionService.getAllTransactions(requestingUserId);
    }
}
