package com.example.daouWeb.domain.admin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin_role")
public class AdminRole implements Serializable {

    private static final long serialVersionUID = -7627983896179604684L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="adminRoleId", nullable = false)
    private Long adminRoleId;

    @Column(name="adminRoleNm", nullable = false)
    private String adminRoleNm;

    public Long getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Long adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getAdminRoleNm() {
        return adminRoleNm;
    }

    public void setAdminRoleNm(String adminRoleNm) {
        this.adminRoleNm = adminRoleNm;
    }
}
