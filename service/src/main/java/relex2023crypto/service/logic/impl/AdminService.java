package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import relex2023crypto.db.entities.AdminEntity;
import relex2023crypto.db.repositories.AdminRepository;
import relex2023crypto.service.logic.IAdminService;
import relex2023crypto.service.logic.utils.AdminAccessProvider;
import relex2023crypto.service.mapper.IAdminMapper;
import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.SecretKeyDto;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
    private static final String PASSWORD = "42";
    private final String SALT = "34";
    private final AdminAccessProvider provider;
    private final AdminRepository rep;
    private final IAdminMapper map;

    @Autowired
    public AdminService(AdminRepository rep, IAdminMapper map, AdminAccessProvider provider) {
        this.rep = rep;
        this.map = map;
        this.provider = provider;
    }

    @Override
    public ResponseDto<SecretKeyDto> createAdmin(Integer requestingUserId, AdminDto dto) {
        Boolean access = provider.checkAdminAccessByUserSecretKey(rep.getById(requestingUserId).getSecretKey());
        logger.info("Requested creating new admin by {}, access: {}",
                requestingUserId, access);

        if (!access) {
            return new ResponseDto<>("Operation denied due to access restriction." +
                    "This operation is only available for admins");
        }

        TextEncryptor encryptor = Encryptors.text(PASSWORD, SALT);
        String encryptedText = encryptor.encrypt(dto.getEmail());

        AdminEntity entity = map.ToEntity(dto);
        entity.setSecretKey(encryptedText);

        rep.save(entity);

        return new ResponseDto<>("Operation succeeded",
                new SecretKeyDto(encryptedText));
    }

    @Override
    public ResponseDto<Integer> deleteAdmin(Integer requestingUserId, Integer adminId) {
        Boolean access = provider.checkAdminAccessByUserSecretKey(rep.getById(requestingUserId).getSecretKey());
        logger.info("Requested deleting admin {} by user {}, access: {}",
                adminId, requestingUserId, access);
        if (!access) {
            return new ResponseDto<>("Operation denied due to access restriction." +
                    "This operation is only available for admins");
        }
        rep.deleteById(adminId);
        return new ResponseDto<Integer>("Admin {} was successfully deleted", adminId);
    }

    @Override
    public ResponseDto<List<AdminDto>> getAllAdmins(Integer requestingUserId) {
        Boolean access = provider.checkAdminAccessByUserSecretKey(rep.getById(requestingUserId).getSecretKey());
        logger.info("Requested all admins info by user {}, access: {}",
                requestingUserId, access);
        if (!access) {
            return new ResponseDto<>("Operation denied due to access restriction." +
                    "This operation is only available for admins");
        }
        return new ResponseDto<>("Operation succeeded",
                Optional.of(rep.findAll())
                        .map(map::fromEntities)
                        .orElseThrow());
    }
}
