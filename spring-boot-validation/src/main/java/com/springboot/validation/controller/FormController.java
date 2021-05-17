package com.springboot.validation.controller;

import com.springboot.validation.dto.Form;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
@RestController
@RequestMapping("/form")
public class FormController {

    @PostMapping
    public Form form(@RequestBody @Valid Form form) {
        return form;
    }
}
