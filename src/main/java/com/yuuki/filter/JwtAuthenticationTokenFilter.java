package com.yuuki.filter;

import com.google.gson.Gson;
import com.yuuki.entity.account.LoginUser;
import com.yuuki.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Yuuki
 * @date 2022/6/7 9:52
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final StringRedisTemplate stringRedisTemplate;

    private final Gson gson;

    @Autowired
    public JwtAuthenticationTokenFilter(StringRedisTemplate stringRedisTemplate, Gson gson) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.gson = gson;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        String username;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            username = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String redisKey = "Login:" + username;
        String s = stringRedisTemplate.opsForValue().get(redisKey);
        LoginUser loginUser = gson.fromJson(s, LoginUser.class);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        //TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);

    }
}
