package com.yuuki.entity.account.DO;

import com.yuuki.enums.account.AccountStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author heyang
 * @date 2022/4/28 11:18
 *
 * 用户基本信息表
 */
@Data
@Entity
@Table(name = "t_account")
public class AccountDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5345846232448578745L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "username", columnDefinition = "varchar(25) comment '账号'")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(1000) comment '密码'")
    private String password;

    @Column(name = "create_date", columnDefinition = "varchar(25) comment '创建时间'")
    private String createDate;

    @Column(name = "update_date", columnDefinition = "varchar(25) comment '创建时间'")
    private String updateDate;

    @Column(name = "status", columnDefinition = "bigint comment '状态'")
    private AccountStatus status;

    @Column(name = "user_id", columnDefinition = "bigint comment '对应user表中的id'")
    private Long userId;

    @Column(name = "role_id", columnDefinition = "bigint comment '对应role表中的id'")
    private Long roleId;
}
