package com.example.daouWeb.security;

import com.example.daouWeb.config.UrlConfig;
import com.example.daouWeb.domain.AuthToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class SecuritySignInSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        if (authentication.getPrincipal() instanceof AuthToken) {

            AuthToken authToken = (AuthToken)authentication.getPrincipal();

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*60*8);
            session.setAttribute("SESSION_INFO", authToken);

            Cookie cookie = new Cookie("TYPE", authToken.getAuth());
            cookie.setMaxAge(60*60*8);
            response.addCookie(cookie);

            String referer = (String)request.getSession().getAttribute("referer");

            if(referer != null && !referer.isEmpty()) {
                setDefaultTargetUrl(referer);
            }
            else {
                logger.debug("get : " + this.getDefaultTargetUrl());
                setDefaultTargetUrl("/board/list");
            }

            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
