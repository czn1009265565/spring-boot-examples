package com.springboot.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

/**
 * @author: zenan
 * @date: 2021/4/14
 */
@Data
@Document(indexName = "product", shards = 1, replicas = 0)
public class EsProduct {
    @Id
    private Long id;

    private Long brandId;

    @Field(type = FieldType.Keyword)
    private String brandName;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;

    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String description;

    private BigDecimal price;

    public EsProduct() {
    }

    public EsProduct(Long id, Long brandId, String brandName, String name, String description, BigDecimal price) {
        this.id = id;
        this.brandId = brandId;
        this.brandName = brandName;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
