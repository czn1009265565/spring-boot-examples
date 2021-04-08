package com.springboot.securityuserauth.dao;

import com.springboot.securityuserauth.entity.UserProfile;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zenan
 * @date: 2021/4/8
 */
public interface UserProfileExtendMapper {

    UserProfile findByUsername(@Param("username") String username);
}
