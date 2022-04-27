package com.yuuki.service.inter;

import com.yuuki.entity.User;
import org.springframework.stereotype.Service;


/**
 * @author Yuuki
 */
@Service
public interface UserService {

    void add(User user);

    User findById(Long id);
}