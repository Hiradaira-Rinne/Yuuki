package com.yuuki.controller;

import com.yuuki.entity.account.UserDO;
import com.yuuki.service.account.LoginService;
import com.yuuki.service.account.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuuki
 * @date 2022/6/6 17:44
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public String login(@RequestBody UserDO userDO) {
        return loginService.login(userDO);
    }
}
