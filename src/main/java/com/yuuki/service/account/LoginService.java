package com.yuuki.service.account;

import com.yuuki.entity.account.DO.UserDO;

/**
 * @author Yuuki
 * @date 2022/6/6 17:50
 */
public interface LoginService {

    String login(UserDO userDO);

    String logout();
}
