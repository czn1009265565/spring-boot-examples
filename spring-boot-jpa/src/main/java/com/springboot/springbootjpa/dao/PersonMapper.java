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

    @Query(value = "select id,name,age from person where name=?1", nativeQuery = true)
    Person findPersonByName(String name);
}
