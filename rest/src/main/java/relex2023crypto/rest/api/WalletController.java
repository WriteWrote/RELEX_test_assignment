package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.IWalletService;
import relex2023crypto.service.model.WalletDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash")
public class WalletController {
    private final IWalletService walletService;

    @Autowired
    public WalletController(IWalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/info/user{userId}")
    public ResponseDto<List<WalletDto>> getUserAllWalletsInfo(@PathVariable Integer requestingUserId,
                                                              @PathVariable Integer userId) {
        return walletService.getUserWallets(requestingUserId, userId);
    }

    @GetMapping("/info/{walletId}")
    public ResponseDto<WalletDto> getWalletInfoById(@PathVariable Integer requestingUserId,
                                                    @PathVariable Integer walletId) {
        return walletService.getWalletById(requestingUserId, walletId);
    }

    @GetMapping("/info/all")
    public ResponseDto<List<WalletDto>> getAllWallets(@PathVariable Integer requestingUserId) {
        return walletService.getAll(requestingUserId);
    }

    @PostMapping("/create")
    public ResponseDto<Integer> createWallet(@RequestBody WalletDto dto) {
        return walletService.createWallet(dto);
    }

    @DeleteMapping("/{walletId}/delete")
    public ResponseDto<Integer> deleteWallet(@PathVariable Integer requestingUserId,
                                             @PathVariable Integer walletId) {
        return walletService.deleteWalletById(requestingUserId, walletId);
    }

}
