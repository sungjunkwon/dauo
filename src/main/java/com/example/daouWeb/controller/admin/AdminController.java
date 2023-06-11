package com.example.daouWeb.controller.admin;

import com.example.daouWeb.domain.admin.Admin;
import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.admin.AdminDTO;
import com.example.daouWeb.service.admin.AdminService;
import com.example.daouWeb.service.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AdminService adminService;
    private CommonService commonService;

    @Autowired
    public AdminController(AdminService adminService, CommonService commonService) {
        this.adminService = adminService;
        this.commonService = commonService;
    }

    /**
     * signin 페이지 요청
     * @return
     */
    @RequestMapping(value="/signin", method = RequestMethod.GET)
    public String signin() {
        return "signin";
    }

    /**
     * 슈퍼 관리자 생성 페이지 요청
     * @return
     */
    @RequestMapping(value = "/signup-super", method = { RequestMethod.GET})
    public String signupSuperView() {
        return "signup_super";
    }

    /**
     * 슈퍼 관리자 생성
     * @param input
     * @return
     */
    @RequestMapping(value="/signup-super", method = RequestMethod.POST)
    public @ResponseBody Result signupSuper(@ModelAttribute AdminDTO input) {
        return commonService.signupSuperAdmin(input);
    }

    @RequestMapping(value="/checkAdmin", method = RequestMethod.POST)
    public @ResponseBody Result checkAdmin(@ModelAttribute Admin input) {
        return adminService.checkAdmin(input);
    }
}
