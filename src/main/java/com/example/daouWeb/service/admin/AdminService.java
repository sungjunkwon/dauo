package com.example.daouWeb.service.admin;

import com.example.daouWeb.domain.admin.Admin;
import com.example.daouWeb.dto.CustomPageResult;
import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.admin.AdminDTO;

public interface AdminService {
    CustomPageResult getAdminListInfoH(CustomSearchParam customSearchParam);

    Admin detailAdminInfoH(Long id);
    Result updateAdminInfoH(Long id, Admin param);
    Result deleteAdminInfoH(Long id);

    Result checkAdmin(Admin param);

    Long totalAdmin();
}
