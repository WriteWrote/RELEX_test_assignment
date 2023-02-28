package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.IWalletService;
import relex2023crypto.service.model.WalletDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.responses.SecretKeyDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash")
public class WalletController {
    private final IWalletService walletService;

    @Autowired
    public WalletController(IWalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/info/all")
    public ResponseDto<List<WalletDto>> getAllWallets(SecretKeyDto dto) {
        return walletService.getAll(dto);
    }
    @GetMapping("/info")
    public ResponseDto<List<WalletDto>> getUserAllWallets(@RequestBody SecretKeyDto dto) {
        return walletService.getUserWallets(dto);
    }

    @GetMapping("/info/{walletId}")
    public ResponseDto<WalletDto> getWalletById(@PathVariable Integer requestingUserId,
                                                @PathVariable Integer walletId) {
        return walletService.getWalletById(requestingUserId, walletId);
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
