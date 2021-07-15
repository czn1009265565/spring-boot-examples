package com.springboot.multipledatatransaction.service.impl;

import com.springboot.multipledatatransaction.dao.DeviceRepository;
import com.springboot.multipledatatransaction.dao.UserMapper;
import com.springboot.multipledatatransaction.entity.Device;
import com.springboot.multipledatatransaction.entity.User;
import com.springboot.multipledatatransaction.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void create() {
        // 创建设备
        Device device2 = new Device();
        device2.setId("2");
        device2.setType(1);
        device2.setName("phone");
        deviceRepository.insert(device2);

        Device device = new Device();
        device.setId("1");
        device.setType(1);
        device.setName("phone");
        deviceRepository.insert(device);

        // 创建user
        userMapper.insert(1L, 18, "Bob");
        userMapper.insert(2L, 18, "Kim");
    }
}
