package com.example.daouWeb.repository.admin;

import com.example.daouWeb.dto.CustomSearchParam;
import com.example.daouWeb.dto.admin.AdminDTO;
import org.springframework.data.domain.Page;

public interface AdminRepositoryCustom {
    long getSAdminCount();
    Page<AdminDTO> getAdminListInfoQ(CustomSearchParam customSearchParam);
}
