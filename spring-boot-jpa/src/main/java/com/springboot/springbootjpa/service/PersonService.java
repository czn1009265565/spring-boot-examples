package com.springboot.springbootjpa.service;

import com.springboot.springbootjpa.entity.Person;

/**
 * @author: zenan
 * @date: 2021/5/24
 */
public interface PersonService {
    Person add(Person person);

    void delete(Long personId);
}
