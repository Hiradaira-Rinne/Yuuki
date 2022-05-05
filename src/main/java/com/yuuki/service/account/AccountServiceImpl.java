package com.yuuki.service.account;

import com.yuuki.entity.account.DO.AccountDO;
import com.yuuki.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Yuuki
 * @date 2022/4/28 17:16
 */
@Service
public class AccountServiceImpl {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * 通过用户名查找用户信息
     *
     * @param username 用户名
     * @return AccountDO 用户账号信息
     */
    public AccountDO findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
