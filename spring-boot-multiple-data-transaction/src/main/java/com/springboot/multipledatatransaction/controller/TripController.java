package com.springboot.multipledatatransaction.controller;

import com.springboot.multipledatatransaction.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/create")
    public String create() {
        tripService.create();
        return "success";
    }
}
