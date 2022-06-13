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
 * @date 2022/6/13 16:14
 */
@Data
@Entity
@Table(name = "t_user_role")
public class UserJoinRoleDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6536841777771185039L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint comment '用户id'")
    private Long userId;

    @Column(name = "role_id", columnDefinition = "bigint comment '角色id'")
    private Long roleId;
}
