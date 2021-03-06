package com.yuuki.service.account.impl;

import com.yuuki.entity.account.LoginUser;
import com.yuuki.entity.account.DO.UserDO;
import com.yuuki.repository.account.UserRepository;
import com.yuuki.service.account.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Yuuki
 * @date 2022/6/2 11:36
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO byUsername = userRepository.findByUsername(username);
        if (Objects.isNull(byUsername)) {
            throw new UsernameNotFoundException("用户名密码错误");
        }
        List<String> permissionKeyList =  userRepository.findPermsByUserId(byUsername.getId());
        return new LoginUser(byUsername, permissionKeyList);
    }


}
