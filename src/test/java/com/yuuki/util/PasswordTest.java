package com.yuuki.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Yuuki
 * @date 2022/6/6 17:17
 */
@SpringBootTest
public class PasswordTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void toCiphertext() {
        String PASSWORD = passwordEncoder.encode("PASSWORD");
        System.out.println(PASSWORD);
    }

    @Test
    public void toPlaintext() {
        String PASSWORD = "$2a$10$gGi5ZILH/qgejWi40pV01ehA5ERyPcXbJJKa5OhFps/tdOtqf9lyy";
        System.out.println(passwordEncoder.matches("PASSWORD", PASSWORD));
    }
}
