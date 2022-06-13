package com.yuuki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Yuuki
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class YuukiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuukiApplication.class, args);
    }

}
