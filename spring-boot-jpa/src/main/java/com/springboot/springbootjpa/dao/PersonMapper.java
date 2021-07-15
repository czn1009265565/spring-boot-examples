package com.springboot.springbootjpa.dao;

import com.springboot.springbootjpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author: zenan
 * @date: 2021/5/24
 */
public interface PersonMapper extends JpaRepository<Person, Long> {

    Person findByName(String name);

    /**
     * nativeQuery=true 则查询语句使用原生sql，不加则使用HQL
     */
    @Query(value = "select id,name,age from person where name=?1", nativeQuery = true)
    Person findPersonByName(String name);
}
