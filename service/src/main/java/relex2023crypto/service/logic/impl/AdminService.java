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
import relex2023crypto.service.model.ResponseDto;

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
    public AdminDto createAdmin(Integer requestingUserId, AdminDto dto) {
        Boolean access = provider.checkAccessByUserId(requestingUserId);
        logger.info("Requested creating new admin by {}, access: {}",
                requestingUserId, access);

        if (!access) {
            return null; //todo: figure out how to insert there Response
                         // normally I would just responded with ResponseDto
                         // with specific message, but the description of API in
                         // the doc with the task description obliged me to return
                         // secretKey when creating new user, so I'm returning the whole AdminDto
        }

        return Optional.of(dto)
                .map(map::ToEntity)
                .map(rep::save)
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public ResponseDto deleteAdmin(Integer requestingUserId, Integer adminId) {
        Boolean access = provider.checkAccessByUserId(requestingUserId);
        logger.info("Requested deleting admin {} by user {}, access: {}",
                adminId, requestingUserId, access);
        if (!access){
            return new ResponseDto("Operation denied");
        }
        rep.deleteById(adminId);
        return new ResponseDto("Admin {} was successfully deleted", adminId);
    }

    @Override
    public List<AdminDto> getAllAdmins(Integer requestingUserId) {
        Boolean access = provider.checkAccessByUserId(requestingUserId);
        logger.info("Requested all admins info by user {}, access: {}",
                requestingUserId, access);
        if (!access){
            return null;    //todo: same problem here
        }
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }
}
