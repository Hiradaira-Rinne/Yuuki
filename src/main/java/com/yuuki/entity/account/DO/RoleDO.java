package com.yuuki.entity.account.DO;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author heyang
 * @date 2022/4/28 11:43
 */
@Data
@Entity
@Table(name = "t_role")
public class RoleDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -3586557281012328565L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(25) comment '权限名称'")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(100) comment '权限描述'")
    private String description;
}
