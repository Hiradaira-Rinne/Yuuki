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
 * @date 2022/6/13 16:11
 */
@Data
@Entity
@Table(name = "t_role_permission")
public class RoleJoinPermissionDO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5248320787644673017L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "role_id", columnDefinition = "bigint comment '角色id'")
    private Long roleId;

    @Column(name = "permission_id", columnDefinition = "bigint comment '权限id'")
    private Long permissionId;

}
