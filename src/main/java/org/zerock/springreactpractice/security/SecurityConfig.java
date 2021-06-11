package org.zerock.springreactpractice.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.zerock.springreactpractice.security.filter.APILoginFailHandler;
import org.zerock.springreactpractice.security.filter.ApiCheckFilter;
import org.zerock.springreactpractice.security.filter.ApiLoginFilter;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApiCheckFilter apiCheckFilter() {
        return new ApiCheckFilter("/api/note/**/*");
    }

    @Bean
    public ApiLoginFilter apiLoginFilter() throws Exception {

        ApiLoginFilter apiLoginFilter = new ApiLoginFilter("/api/login");
        apiLoginFilter.setAuthenticationManager(authenticationManager());
        apiLoginFilter.setAuthenticationFailureHandler(new APILoginFailHandler());

        return apiLoginFilter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(apiCheckFilter(), UsernamePasswordAuthenticationFilter.class);

    }

}
