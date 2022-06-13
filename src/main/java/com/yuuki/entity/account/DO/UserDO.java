package com.yuuki.entity.account.DO;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Yuuki
 * @date 2022/6/2 11:19
 * @description 用户表， 对应数据库t_user
 */
@Data
@Entity
@Table(name = "t_user")
public class UserDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8286533391502406417L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "username", columnDefinition = "varchar(25) comment '账号'")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(64) comment '密码'")
    private String password;

    @Column(name = "status", columnDefinition = "varchar(1) comment '账号状态(0-正常， 1-停用)'")
    private String status;

    @Column(name = "create_time", columnDefinition = "varchar(20) comment '创建时间'")
    private String createTime;

    @Column(name = "update_time", columnDefinition = "varchar(20) comment '修改时间'")
    private String updateTime;

    @Column(name = "del_flag", columnDefinition = "varchar(1) comment '删除标志(0-未删除， 1-已删除)'")
    private String delFlag;
}
