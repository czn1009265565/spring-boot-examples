package com.springboot.securityjwtphone.dao;

import com.springboot.securityjwtphone.entity.UserProfile;

/**
 * @author: zenan
 * @date: 2021/4/22
 */
public interface UserProfileExtendMapper {

    UserProfile findByMobile(String mobile);
}
