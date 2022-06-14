package com.yuuki.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuuki
 * @date 2022/5/5 14:33
 */
@RestController
public class YuukiController {

    @GetMapping("/yuuki")
    @PreAuthorize("hasAuthority('Yuuki')")
    public String yuuki() {
        return "hello yuuki";
    }
}
