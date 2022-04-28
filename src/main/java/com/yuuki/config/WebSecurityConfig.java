package com.yuuki.config;

import com.yuuki.filter.JwtLoginFilter;
import com.yuuki.service.intf.account.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Yuuki
 * @date 2022/4/28 17:16
 */
@Configuration
@EnableWebSecurity      //加了这个注解才能写SpringSecurity相关的配置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccountService accountService;



    public WebSecurityConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证用户的来源
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //数据库中
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
    }

    /**
     * 配置SpringSecurity相关信息
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()  //关闭csrf
                .addFilter(new JwtLoginFilter(super.authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);    //禁用session
    }

}
