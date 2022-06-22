package com.yuuki.controller;

import com.yuuki.entity.account.DO.UserDO;
import com.yuuki.entity.response.ResponseEntity;
import com.yuuki.service.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuuki
 * @date 2022/6/6 17:44
 */
@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody UserDO userDO) {
        return loginService.login(userDO);
    }

    @GetMapping("/user/logout")
    public ResponseEntity<String> logout() {
        return loginService.logout();
    }
}
