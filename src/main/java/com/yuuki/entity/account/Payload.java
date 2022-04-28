package com.yuuki.entity.account;

import lombok.Data;

import java.util.Date;

/**
 * @author Yuuki
 * @date 2022/4/28 17:16
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
