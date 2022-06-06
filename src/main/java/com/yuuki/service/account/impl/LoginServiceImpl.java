package com.yuuki.service.account.impl;

import com.google.gson.Gson;
import com.yuuki.entity.account.LoginUser;
import com.yuuki.entity.account.UserDO;
import com.yuuki.service.account.LoginService;
import com.yuuki.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    public LoginServiceImpl(AuthenticationManager authenticationManager, Gson gson) {
        this.authenticationManager = authenticationManager;
        this.gson = gson;
    }

    @Override
    public String login(UserDO userDO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDO.getUsername(), userDO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String jwt = JwtUtil.createJWT(loginUser.getUserDO().getUsername());
        Map<Object, Object> result = new HashMap<>();
        result.put("Token", jwt);
        return gson.toJson(result);
    }
}
