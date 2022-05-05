package com.yuuki.service.account;

import com.yuuki.entity.account.DO.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heyang
 * @date 2022/5/5 15:55
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AccountServiceImpl accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountDO accountDO = accountService.findByUsername(username);
        if (accountDO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //暂时不考虑权限
        List<GrantedAuthority> authorities = new ArrayList<>();

        //如果在创建用户信息的时候没有加密，这里就需要做加密处理否则会报错
        User userDetails = new User(accountDO.getUsername(), passwordEncoder.encode(accountDO.getPassword()), authorities);

        return userDetails;
    }

}
