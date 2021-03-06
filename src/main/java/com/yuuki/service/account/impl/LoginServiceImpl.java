package com.yuuki.service.account.impl;

import com.google.gson.Gson;
import com.yuuki.entity.account.LoginUser;
import com.yuuki.entity.account.DO.UserDO;
import com.yuuki.entity.response.ResponseEntity;
import com.yuuki.service.account.LoginService;
import com.yuuki.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<String> login(UserDO userDO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDO.getUsername(), userDO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String jwt = JwtUtil.createJWT(loginUser.getUserDO().getUsername());
        LoginUser loginUserToRedis = new LoginUser(loginUser.getUserDO(), loginUser.getPermissions());

        // 用户信息存入redis
        stringRedisTemplate.opsForValue().set("Login:" + loginUser.getUserDO().getUsername(), gson.toJson(loginUserToRedis));
        return new ResponseEntity<>(jwt);
    }

    @Override
    public ResponseEntity<String> logout() {
        // 获取SecurityContextHolder中用户信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) usernamePasswordAuthenticationToken.getPrincipal();
        String username = loginUser.getUserDO().getUsername();
        // 删除redis中的值
        stringRedisTemplate.delete("Login:" + username);
        return new ResponseEntity<>();
    }
}
