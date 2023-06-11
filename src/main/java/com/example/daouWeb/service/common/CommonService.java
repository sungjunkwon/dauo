package com.example.daouWeb.service.common;

import com.example.daouWeb.domain.admin.Admin;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.admin.AdminDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CommonService extends UserDetailsService {
    Result signupSuperAdmin(AdminDTO input);

    Result signupAdmin(Admin input);

    boolean isExistSuperUser();
}
