package com.example.daouWeb.domain.admin;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = -6636022348353051579L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="admin_no", nullable = false)
    private Long adminNo;

    @Column(name="admin_id", nullable = false)
    private String adminId;

    @Column(name="admin_pw", nullable = false)
    private String adminPw;

    @Column(name="admin_nm", nullable = false)
    private String adminNm;

    @Column(name="admin_auth", nullable = false)
    private Long adminAuth;

    @Column(name="reg_dt")
    private LocalDateTime regDt;

    @Column(name="upd_dt")
    private LocalDateTime updDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="adminAuth", updatable = false, insertable = false)
    private AdminRole adminRole;

    public Admin(){};

    public Admin(String adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    public Admin(Long adminNo, String adminId, String adminPw, String adminNm, LocalDateTime regDt) {
        this.adminNo = adminNo;
        this.adminId = adminId;
        this.adminPw = adminPw;
        this.adminNm = adminNm;
        this.regDt = regDt;
    }

    public Long getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Long adminNo) {
        this.adminNo = adminNo;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }

    public String getAdminNm() {
        return adminNm;
    }

    public void setAdminNm(String adminNm) {
        this.adminNm = adminNm;
    }

    public LocalDateTime getRegDt() {
        return regDt;
    }

    public void setRegDt(LocalDateTime regDt) {
        this.regDt = regDt;
    }

    public LocalDateTime getUpdDt() {
        return updDt;
    }

    public void setUpdDt(LocalDateTime updDt) {
        this.updDt = updDt;
    }

    public Long getAdminAuth() {
        return adminAuth;
    }

    public void setAdminAuth(Long adminAuth) {
        this.adminAuth = adminAuth;
    }

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }
}
