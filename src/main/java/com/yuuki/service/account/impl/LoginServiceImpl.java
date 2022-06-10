package com.yuuki.service.account.impl;

import com.google.gson.Gson;
import com.yuuki.entity.account.LoginUser;
import com.yuuki.entity.account.UserDO;
import com.yuuki.service.account.LoginService;
import com.yuuki.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuuki
 * @date 2022/6/6 17:50
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final Gson gson;

    private final AuthenticationManager authenticationManager;

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, Gson gson, StringRedisTemplate stringRedisTemplate) {
        this.authenticationManager = authenticationManager;
        this.gson = gson;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public String login(UserDO userDO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDO.getUsername(), userDO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String jwt = JwtUtil.createJWT(loginUser.getUserDO().getUsername());
        Map<Object, Object> result = new HashMap<>();
        result.put("Token", jwt);
        // 用户信息存入redis
        stringRedisTemplate.opsForValue().set("Login:" + loginUser.getUserDO().getUsername(), gson.toJson(loginUser));
        return gson.toJson(result);
    }

    @Override
    public String logout() {
        // 获取SecurityContextHolder中用户信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext();
        LoginUser loginUser = (LoginUser) usernamePasswordAuthenticationToken.getPrincipal();
        String username = loginUser.getUserDO().getUsername();
        // 删除redis中的值
        stringRedisTemplate.delete("Login:" + username);
        return "logout success";
    }
}
