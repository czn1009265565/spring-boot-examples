package com.springboot.springbootjpa.controller;

import com.springboot.springbootjpa.entity.Person;
import com.springboot.springbootjpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zenan
 * @date: 2021/5/24
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Boolean add(@RequestBody Person person) {
        personService.add(person);
        return true;
    }

    @DeleteMapping("/{personId}")
    public Boolean delete(@PathVariable(value = "personId") Long personId) {
        personService.delete(personId);
        return true;
    }
}
