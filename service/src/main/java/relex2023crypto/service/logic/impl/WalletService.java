package relex2023crypto.service.logic.impl;

import org.springframework.stereotype.Service;
import relex2023crypto.service.logic.IWalletService;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

@Service
public class WalletService implements IWalletService {
    @Override
    public WalletDto getWalletById(Integer requestingUserId, Integer walletId) {
        return null;
    }

    @Override
    public List<WalletDto> getUserWallets(Integer userId) {
        return null;
    }

    @Override
    public List<WalletDto> getAll(Integer requestingUserId) {
        return null;
    }
}
