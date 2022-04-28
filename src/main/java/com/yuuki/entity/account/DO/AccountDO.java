package com.yuuki.entity.account.DO;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author heyang
 * @date 2022/4/28 11:18
 *
 * 用户基本信息表
 */
@Data
@Table(name = "t_user")
public class UserDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5345846232448578745L;


    private String username;

    private String password;

    private String createDate;

    private String updateDate;

    private String 

}
