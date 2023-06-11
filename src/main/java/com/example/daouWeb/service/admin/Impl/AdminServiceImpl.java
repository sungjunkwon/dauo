package com.example.daouWeb.service.admin.Impl;

import com.example.daouWeb.domain.admin.Admin;
import com.example.daouWeb.dto.CustomPageResult;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.admin.AdminDTO;
import com.example.daouWeb.enumResCode.EnumResCode;
import com.example.daouWeb.repository.admin.AdminRepository;
import com.example.daouWeb.service.admin.AdminService;
import com.example.daouWeb.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Long totalAdmin() {
        return adminRepository.count();
    }

    @Override
    public CustomPageResult getAdminListInfoH(CustomSearchParam customSearchParam) {
        CustomPageResult pageResult = new CustomPageResult(customSearchParam);
        pageResult.setPageResult(adminRepository.getAdminListInfoQ(customSearchParam));
        return pageResult;
    }

    @Override
    public Admin detailAdminInfoH(Long id) {
        return adminRepository.findByAdminNo(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Result updateAdminInfoH(Long id, Admin param) {
        Admin admin = adminRepository.findByAdminNo(id);

        if(admin == null){
            return new Result(EnumResCode.E001);
        }

        logger.info("[UPDATE] admin ID : "+ admin.getAdminId() +", admin Name : "+ admin.getAdminNm());
        param.setAdminNo(id);
        // param.setCreateDt(admin.getCreateDt());
        if (param.getAdminPw() != null && param.getAdminPw().length() > 0) {
            param.setAdminPw(CommonUtil.encryptPassword(new BCryptPasswordEncoder(), param.getAdminPw()));
        } else {
            param.setAdminPw(admin.getAdminPw());
        }
        adminRepository.save(param);

        return new Result(EnumResCode.OK);
    }

    @Override
    @Transactional(readOnly = false)
    public Result deleteAdminInfoH(Long id) {
        Admin admin = adminRepository.findByAdminNo(id);

        if(admin == null)
            return new Result(EnumResCode.E001);

        try {
            logger.info("[DELETE] admin ID : " + admin.getAdminId() + ", admin Name : "+ admin.getAdminNm());
            adminRepository.delete(admin);
        }catch (Exception e){
            logger.error("[ERROR] deleteAdminInfo : " + e.getMessage());
            return new Result(EnumResCode.E013);
        }

        return new Result(EnumResCode.OK);
    }

    @Override
    public Result checkAdmin(Admin param) {
        Admin admin = adminRepository.findByAdminId(param.getAdminId());

        if(admin == null){
            return new Result(EnumResCode.E004);
        }else{
            return new Result(EnumResCode.OK);
        }

    }
}
