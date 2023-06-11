package com.example.daouWeb.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CommonUtil {
    public static String encryptPassword(PasswordEncoder passwordEncoder, String originPassword) {
        return passwordEncoder.encode(originPassword);
    }

    public static boolean isPasswordMatched(PasswordEncoder passwordEncoder, String rawPwd, String encodedPwd) {
        return passwordEncoder.matches(rawPwd, encodedPwd);
    }

}
