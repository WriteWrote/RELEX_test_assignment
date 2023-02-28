package relex2023crypto.service.logic;

import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

public interface IWalletService {
    WalletDto getWalletById(Integer requestingUserId,
                            Integer walletId);

    ResponseDto deleteWalletById(Integer requestingUserId,
                                 Integer walletID);
    ResponseDto createWallet(WalletDto dto);
    List<WalletDto> getUserWallets(Integer userId);

    List<WalletDto> getAll(Integer requestingUserId);
}
