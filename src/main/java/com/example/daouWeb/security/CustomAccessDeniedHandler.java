package com.example.daouWeb.security;

import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        if(request.getMethod().equals("GET")){
            this.setErrorPage("/access_denied");
            super.handle(request, response, accessDeniedException);
        }else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=utf-8");

            JSONObject json = new JSONObject();
            json.put("code", "401");
            json.put("message","권한이 없습니다.");
            PrintWriter out = response.getWriter();
            out.print(json);
        }

    }
}
