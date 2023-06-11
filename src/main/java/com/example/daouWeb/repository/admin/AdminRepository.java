package com.example.daouWeb.repository.admin;

import com.example.daouWeb.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>, AdminRepositoryCustom {
    Admin findByAdminId(String adminId);
    Admin findByAdminNo(Long adminNo);
    Admin findByAdminNm(String adminNm);
}
