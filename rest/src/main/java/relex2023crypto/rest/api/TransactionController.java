package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import relex2023crypto.service.logic.ITransactionService;

import relex2023crypto.service.model.WalletDto;
import relex2023crypto.service.model.requests.DateGapRequest;
import relex2023crypto.service.model.requests.ExchangeRequest;
import relex2023crypto.service.model.responses.ExchangeResponseDto;
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
    public ResponseDto<WalletDto> cashOut(@PathVariable Integer requestingUserId,
                                          @RequestBody TransactionDto transactionDto) {
        return transactionService.cashOut(requestingUserId, transactionDto);
    }

    @PostMapping("/in")
    public ResponseDto<WalletDto> cashIn(@PathVariable Integer requestingUserId,
                                         @RequestBody TransactionDto transactionDto) {
        return transactionService.cashIn(requestingUserId, transactionDto);
    }

    @PostMapping("/exchange")
    public ResponseDto<ExchangeResponseDto> cashExchange(@PathVariable Integer requestingUserId,
                                                         @RequestBody ExchangeRequest dto) {
        return transactionService.cashExchange(requestingUserId, dto);
    }

    @GetMapping("/{userId}")
    public ResponseDto<List<TransactionDto>> getUserTransactionHistory(@PathVariable Integer requestingUserId,
                                                                       @PathVariable Integer userId) {
        return transactionService.getUserTransactionHistory(requestingUserId, userId);
    }

    @GetMapping("/all")
    public ResponseDto<List<TransactionDto>> getAllUsersTransactionHistory(@PathVariable Integer requestingUserId) {
        return transactionService.getAllTransactions(requestingUserId);
    }

    @GetMapping("/between")
    public ResponseDto<Integer> getTransactionCountBetweenDates(@RequestBody DateGapRequest dto) {
        return transactionService.getTransactionsInDateGap(dto);
    }
}
