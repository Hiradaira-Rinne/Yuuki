package com.yuuki.entity.account.DO;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author heyang
 * @date 2022/4/28 11:41
 */
@Data
@Entity
@Table(name = "t_user")
public class UserDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5972417687089563754L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint comment '主键id 自增'")
    private Long id;

    @Column(name = "uid", columnDefinition = "bigint comment '用户uid'")
    private Long uid;

    @Column(name = "head_portrait", columnDefinition = "bigint comment '用户头像'")
    private Long headPortrait;

    @Column(name = "nickname", columnDefinition = "varchar(16) comment '用户昵称'")
    private String nickname;

    @Column(name = "age", columnDefinition = "bigint comment '用户年龄'")
    private Integer age;

    @Column(name = "gender", columnDefinition = "bigint comment '用户性别'")
    private Integer gender;

    @Column(name = "birthday", columnDefinition = "varchar(25) comment '用户生日'")
    private Integer birthday;

    @Column(name = "create_date", columnDefinition = "varchar(25) comment '创建时间'")
    private String createDate;

    @Column(name = "update_date", columnDefinition = "varchar(25) comment '创建时间'")
    private String updateDate;

    @Column(name = "personalized_signature", columnDefinition = "varchar(25) comment '个性签名'")
    private String personalizedSignature;

}
