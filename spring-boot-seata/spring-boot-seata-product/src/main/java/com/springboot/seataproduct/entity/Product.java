package com.springboot.seataproduct.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zenan
 * @date: 2021/5/23
 */
@Data
@Entity
@Table(name = "t_product")
public class Product {

    @Id
    private Long productId;

    private Integer count;

}
