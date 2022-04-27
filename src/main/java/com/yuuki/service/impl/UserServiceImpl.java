package com.yuuki.service.impl;

import com.yuuki.entity.User;
import com.yuuki.repository.UserRepository;
import com.yuuki.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Yuuki
 */
@Service
public class UserServiceImpl {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(User user) {
        userRepository.save(user);
    }


    public User findById(Long id) {
        User user = new User();
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        return user;
    }
}
