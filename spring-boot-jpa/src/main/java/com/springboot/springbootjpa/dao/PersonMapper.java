package com.springboot.springbootjpa.dao;

import com.springboot.springbootjpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: zenan
 * @date: 2021/5/24
 */
public interface PersonMapper extends JpaRepository<Person, Long> {
}
