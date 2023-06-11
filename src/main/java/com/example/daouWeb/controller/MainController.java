package com.example.daouWeb.controller;

import com.example.daouWeb.dto.Result;
import com.example.daouWeb.dto.admin.AdminDTO;
import com.example.daouWeb.service.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CommonService commonService;

    @Autowired
    public MainController(CommonService commonService) {
        this.commonService = commonService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        return "main";
    }

}

