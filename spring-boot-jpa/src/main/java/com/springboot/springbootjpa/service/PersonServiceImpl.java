package com.springboot.springbootjpa.service;

import com.springboot.springbootjpa.dao.PersonMapper;
import com.springboot.springbootjpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zenan
 * @date: 2021/5/24
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person add(Person person) {
        return personMapper.save(person);
    }

    @Override
    public void delete(Long personId) {
        personMapper.deleteById(personId);
    }
}
