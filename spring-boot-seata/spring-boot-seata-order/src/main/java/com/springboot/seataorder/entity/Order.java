package com.springboot.seataorder.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author: zenan
 * @date: 2021/5/31
 */
@Data
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    private Long orderId;

    private Long productId;

    private LocalDateTime createTime;
}
