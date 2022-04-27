package com.yuuki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.yuuki")
public class YuukiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuukiApplication.class, args);
    }

}
