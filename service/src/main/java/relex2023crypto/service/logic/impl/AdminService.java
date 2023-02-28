package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.AdminRepository;
import relex2023crypto.service.logic.IAdminService;
import relex2023crypto.service.logic.utils.AccessProvider;
import relex2023crypto.service.mapper.IAdminMapper;
import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
    private final AccessProvider provider;
    private final AdminRepository rep;
    private final IAdminMapper map;

    @Autowired
    public AdminService(AdminRepository rep, IAdminMapper map, AccessProvider provider) {
        this.rep = rep;
        this.map = map;
        this.provider = provider;
    }

    @Override
    public ResponseDto<AdminDto> createAdmin(Integer requestingUserId, AdminDto dto) {
        Boolean access = provider.checkAccessByUserId(requestingUserId);
        logger.info("Requested creating new admin by {}, access: {}",
                requestingUserId, access);

        if (!access) {
            return new ResponseDto<>("Operation denied due to access restriction." +
                    "This operation is only available for admins");
        }


        return new ResponseDto<AdminDto>("Operation succeeded",
                Optional.of(dto)
                        .map(map::ToEntity)
                        .map(rep::save)
                        .map(map::fromEntity)
                        .orElseThrow());
    }

    @Override
    public ResponseDto<Integer> deleteAdmin(Integer requestingUserId, Integer adminId) {
        Boolean access = provider.checkAccessByUserId(requestingUserId);
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
        Boolean access = provider.checkAccessByUserId(requestingUserId);
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
