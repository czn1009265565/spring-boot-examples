package com.springboot.multipledatatransaction.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
@Data
@Document(collection = "device")
public class Device {
    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "type")
    private Integer type;
}
