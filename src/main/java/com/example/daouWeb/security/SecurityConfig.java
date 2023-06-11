package com.example.daouWeb.security;

import com.example.daouWeb.config.UrlConfig;
import com.example.daouWeb.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private SecuritySignInSuccessHandler securitySignInSuccessHandler;
    private SecuritySignInFailHandler securitySignInFailHandler;
    private SecuritySignOutSuccessHandler securitySignOutSuccessHandler;
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private CommonService commonService;

    @Autowired
    public SecurityConfig(SecuritySignInSuccessHandler securitySignInSuccessHandler, SecuritySignInFailHandler securitySignInFailHandler, SecuritySignOutSuccessHandler securitySignOutSuccessHandler, CustomAccessDeniedHandler customAccessDeniedHandler, CustomAuthenticationEntryPoint customAuthenticationEntryPoint, CommonService commonService) {
        this.securitySignInSuccessHandler = securitySignInSuccessHandler;
        this.securitySignInFailHandler = securitySignInFailHandler;
        this.securitySignOutSuccessHandler = securitySignOutSuccessHandler;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.commonService = commonService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(commonService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(UrlConfig.DEFAULT_WEB_IGNORE_MATCHER);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers()
                .and()
                    .csrf().disable()
                    .antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers("/signin").anonymous()
                    //.antMatchers("/**").hasAnyAuthority("Supervisor","Manager","User")
                    .antMatchers("/**").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/board/**").permitAll()
                    .antMatchers("/signup-super").permitAll()
                    .antMatchers(UrlConfig.AUTHENTICATION_WHITE_LIST).permitAll()
                .and()
                    .csrf().disable()
                    .formLogin()
                    .loginPage(UrlConfig.DEFAULT_SIGNIN_PAGE_URL)
                    .loginProcessingUrl(UrlConfig.DEFAULT_SIGNIN_PAGE_URL)
                    .usernameParameter("adminId")
                    .passwordParameter("adminPw")
                    .successHandler(securitySignInSuccessHandler)
                    .failureHandler(securitySignInFailHandler)
                .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutUrl(UrlConfig.DEFAULT_SIGNOUT_PROCESS_URL)
                    .logoutSuccessHandler(securitySignOutSuccessHandler)
                .and()
                    .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
                .and()
                    .csrf().disable();

    }
}
