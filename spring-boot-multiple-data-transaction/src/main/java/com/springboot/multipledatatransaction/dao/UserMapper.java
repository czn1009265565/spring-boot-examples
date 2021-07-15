package com.springboot.multipledatatransaction.dao;

import com.springboot.multipledatatransaction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
public interface UserMapper extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "insert into user(`id`,`age`,`name`) values(?1, ?2, ?3)", nativeQuery = true)
    int insert(@Param("id") Long id, @Param("age") Integer age, @Param("name") String name);
}
