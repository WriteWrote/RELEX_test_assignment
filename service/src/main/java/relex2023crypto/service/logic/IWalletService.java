package relex2023crypto.service.logic;

import relex2023crypto.service.model.WalletDto;

import java.util.List;

public interface IWalletService {
    WalletDto getWalletById(Integer requestingUserId,
                            Integer walletId);
    List<WalletDto> getUserWallets(Integer userId);

    List<WalletDto> getAll(Integer requestingUserId);
}
