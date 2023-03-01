package relex2023crypto.service.logic;

import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.WalletDto;
import relex2023crypto.service.model.SecretKeyDto;

import java.util.List;

public interface IWalletService {
    ResponseDto<WalletDto> getWalletById(Integer requestingUserId,
                                         Integer walletId);

    ResponseDto<Integer> deleteWalletById(Integer requestingUserId,
                                          Integer walletID);

    ResponseDto<Integer> createWallet(WalletDto dto);

    ResponseDto<List<WalletDto>> getUserWallets(SecretKeyDto dto);

    ResponseDto<List<WalletDto>> getAll(SecretKeyDto dto);
}
