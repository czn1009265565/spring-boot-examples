package com.springboot.springbootjpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zenan
 * @date: 2021/5/24
 */
@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    private Long id;

    private String name;

    private Integer age;
}
