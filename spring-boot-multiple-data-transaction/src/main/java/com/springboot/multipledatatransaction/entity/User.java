package com.springboot.multipledatatransaction.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;

    private String name;

    private Integer age;
}
