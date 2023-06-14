package com.example.daouWeb.config;

public class UrlConfig {

    public final static String MAIN_URL = "/";
    public final static String DEFAULT_SIGNIN_PAGE_URL = "/signin";
    public final static String DEFAULT_SIGNIN_PROCESS_URL = "/signin_process";
    public final static String DEFAULT_SIGNUP_SUPER_ADMIN = "/signup-super";
    public final static String DEFAULT_SIGNOUT_PROCESS_URL = "/signout";

    public final static String PERMISSION_ERROR_PAGE_URL = "/permission-error";

    public final static String [] DEFAULT_WEB_IGNORE_MATCHER = {"/main", "/","/signup-super", "/checkAdmin", "/img/**", "/css/**", "/js/**", "/font/**", "/data/**", "/vendor/**", "/swagger-resources", "/configuration/security", "/webjars/**"};
    public final static String [] REQUIRED_AUTHENTICATION_LIST = {"/**"};
    public final static String [] AUTHENTICATION_WHITE_LIST = {DEFAULT_SIGNUP_SUPER_ADMIN, PERMISSION_ERROR_PAGE_URL, DEFAULT_SIGNOUT_PROCESS_URL};
}
