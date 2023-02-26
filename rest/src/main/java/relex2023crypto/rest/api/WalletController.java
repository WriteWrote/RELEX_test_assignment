package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.IWalletService;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash")
public class WalletController {
    private final IWalletService walletService;

    @Autowired
    public WalletController(IWalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/info")
    public List<WalletDto> getUserAllWalletsInfo(@PathVariable Integer requestingUserId){
        return walletService.getUserWallets(requestingUserId);
    }

    @GetMapping("/info/{walletId}")
    public WalletDto getWalletInfoById(@PathVariable Integer requestingUserId,
                                           @PathVariable Integer walletId){
        return walletService.getWalletById(requestingUserId, walletId);
    }

    @GetMapping("/info/all")
    public List<WalletDto> getAllWallets(@PathVariable Integer requestingUserId){
        return walletService.getAll(requestingUserId);
    }


}
