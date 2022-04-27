package com.yuuki.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Yuuki
 */
@Table(name = "t_user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

}
