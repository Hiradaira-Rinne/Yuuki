package com.yuuki.service.account;

import com.yuuki.entity.account.UserDO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Yuuki
 * @date 2022/6/6 17:48
 */
public interface UserService extends UserDetailsService {
    public void login(UserDO userDO);
}
