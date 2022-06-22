package com.yuuki.service.account;

import com.yuuki.entity.account.DO.UserDO;
import com.yuuki.entity.response.ResponseEntity;

/**
 * @author Yuuki
 * @date 2022/6/6 17:50
 */
public interface LoginService {

    ResponseEntity<String> login(UserDO userDO);

    ResponseEntity<String> logout();
}
