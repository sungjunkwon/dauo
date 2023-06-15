package com.example.daouWeb.service.common.Impl;

import com.example.daouWeb.domain.AuthToken;
import com.example.daouWeb.domain.admin.Admin;
import com.example.daouWeb.domain.admin.AdminRole;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.admin.AdminDTO;
import com.example.daouWeb.enumResCode.EnumResCode;
import com.example.daouWeb.repository.admin.AdminRepository;
import com.example.daouWeb.service.common.CommonService;
import com.example.daouWeb.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AdminRepository adminRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public CommonServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Result signupSuperAdmin(Admin input) {

        Result result;

        LocalDateTime curDate = LocalDateTime.now();

        Admin admin = new Admin();

        admin.setAdminNm(input.getAdminNm());
        admin.setAdminId(input.getAdminId());
        admin.setAdminPw(CommonUtil.encryptPassword(new BCryptPasswordEncoder(), input.getAdminPw()));
        admin.setAdminPhone(input.getAdminPhone());
        admin.setAdminAuth((long) 1);
        admin.setRegDt(curDate);

        if(adminRepository.findByAdminId(input.getAdminId()) != null){
            result = new Result(EnumResCode.E006);
        }else{
            adminRepository.save(admin);
            result = new Result(EnumResCode.OK);
        }

        return result;
    }

    @Override
//    @Transactional(rollbackFor=Exception.class, readOnly = false)
    public Result signupAdmin(Admin input) {

        Result result = new Result(EnumResCode.OK);

        LocalDateTime curDate = LocalDateTime.now();

        Admin admin = new Admin();

        admin.setAdminNm(input.getAdminNm());
        admin.setAdminId(input.getAdminId());
        admin.setAdminPw(CommonUtil.encryptPassword(new BCryptPasswordEncoder(), input.getAdminPw()));
        //admin.setAdminPw(passwordEncoder.encode(input.getAdminPw()));
        admin.setAdminAuth((long) 1);
        admin.setRegDt(curDate);

        adminRepository.save(admin);

        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public boolean isExistSuperUser() {
        return (adminRepository.getSAdminCount() > 0);
    }

    @Override
//    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
        logger.debug("Admin Login Process");

        Admin admin = adminRepository.findByAdminId(adminId);

        if(admin == null)
            throw new UsernameNotFoundException("Admin Not Found");

        AuthToken authToken = new AuthToken();
        authToken.setNo(admin.getAdminNo());
        authToken.setId(admin.getAdminId());
        authToken.setPassword(admin.getAdminPw());
        authToken.setName(admin.getAdminNm());

        ArrayList<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("Supervisor"));

        authToken.setAuthorities(grantedAuths);

        return authToken;
    }
}
