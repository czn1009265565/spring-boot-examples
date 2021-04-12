package com.springboot.securityjwt.dao;

import com.springboot.securityjwt.entity.UserProfile;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zenan
 * @date: 2021/4/12
 */
public interface UserProfileExtendMapper {

    UserProfile findByUsername(@Param("username") String username);
}
