package com.mine.warriorsmonitoradmin.configuration;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Program: warriors-party
 * @Description: 监控服务认证配置
 * @Author: Mine.Lee
 * @Create: 2018-12-15 18:42
 * @Version: v1.0
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");

        http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**")
                .permitAll()
                .antMatchers(adminContextPath + "/login")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(adminContextPath + "/login")
                .successHandler(successHandler)
                .and()
                .logout()
                .logoutUrl(adminContextPath + "/logout")
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }
}
