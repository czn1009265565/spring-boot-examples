package com.springboot.multipledatatransaction.dao;

import com.springboot.multipledatatransaction.entity.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {
}
