package com.springboot.springbootswagger.controller;

import com.springboot.springbootswagger.dto.UserBrief;
import com.springboot.springbootswagger.dto.UserDetail;
import com.springboot.springbootswagger.dto.UserForm;
import com.springboot.springbootswagger.dto.UserParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/24
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping
    @ApiOperation(value = "新增用户")
    public String create(@RequestBody UserForm userForm) {
        return "success";
    }

    @GetMapping
    @ApiOperation(value = "用户列表查询")
    public List<UserBrief> list(UserParam userParam) {
        return new ArrayList<>();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "用户详情")
    public UserDetail detail(@PathVariable("userId") Long userId) {
        return new UserDetail();
    }
}
