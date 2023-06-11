package com.example.daouWeb.dto.admin;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdminDTO implements Serializable {

    private static final long serialVersionUID = -6600766116795463755L;

    private Long adminNo;
    private String adminId;
    private String adminPw;
    private String adminNm;
    private Long adminAuth;

    private LocalDateTime regDt;
    private LocalDateTime updDt;

    public AdminDTO(Long adminNo, String adminId, String adminPw, String adminNm, Long adminAuth, LocalDateTime regDt, LocalDateTime updDt) {
        this.adminNo = adminNo;
        this.adminId = adminId;
        this.adminPw = adminPw;
        this.adminNm = adminNm;
        this.adminAuth = adminAuth;
        this.regDt = regDt;
        this.updDt = updDt;
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

    public Long getAdminAuth() {
        return adminAuth;
    }

    public void setAdminAuth(Long adminAuth) {
        this.adminAuth = adminAuth;
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
}
