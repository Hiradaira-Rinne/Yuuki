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
 * @date 2022/6/13 15:13
 */
@Data
@Entity
@Table(name = "t_role")
public class RoleDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8151046438081754159L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "description", columnDefinition = "varchar(500) comment '描述'")
    private String description;

    @Column(name = "role_name", columnDefinition = "varchar(20) comment '角色名称'")
    private String roleName;

    @Column(name = "status", columnDefinition = "varchar(1) comment '角色状态(0-正常， 1-停用)'")
    private String status;

    @Column(name = "create_by", columnDefinition = "varchar(20) comment '创建人'")
    private String createBy;

    @Column(name = "create_time", columnDefinition = "varchar(20) comment '创建时间'")
    private String createTime;

    @Column(name = "update_by", columnDefinition = "varchar(20) comment '修改人'")
    private String updateBy;

    @Column(name = "update_time", columnDefinition = "varchar(20) comment '修改时间'")
    private String updateTime;

    @Column(name = "del_flag", columnDefinition = "varchar(1) comment '删除标志(0-未删除， 1-已删除)'")
    private String delFlag;
}
