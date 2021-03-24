package com.springboot.shardingtable.service;

import com.springboot.shardingtable.dao.UserMapper;
import com.springboot.shardingtable.entity.User;
import com.springboot.shardingtable.entity.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/23
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int create(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User findById(Integer userId) {
        UserExample example = new UserExample();
        example.or().andIdEqualTo(userId);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size() < 1) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public User findByUsername(String username) {
        UserExample example = new UserExample();
        example.or().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size() < 1) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public List<User> list() {
        return userMapper.selectByExample(new UserExample());
    }
}
