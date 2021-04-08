package com.springboot.securityuserauth.security;

import com.springboot.securityuserauth.dao.UserProfileMapper;
import com.springboot.securityuserauth.entity.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author: zenan
 * @date: 2021/4/8
 */
@SpringBootTest
public class SecurityTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserProfileMapper userProfileMapper;

    @Test
    public void createUser() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername("zenan");
        userProfile.setEnabled(true);
        userProfile.setEmail("1009265565@qq.com");
        userProfile.setRoles("ROLE_USER");
        userProfile.setPassword(passwordEncoder.encode("zenan"));
        userProfileMapper.insertSelective(userProfile);
    }

    @Test
    public void createAdmin() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername("root");
        userProfile.setEnabled(true);
        userProfile.setEmail("1009265565@qq.com");
        userProfile.setRoles("ROLE_USER,ROLE_ADMIN");
        userProfile.setPassword(passwordEncoder.encode("root"));
        userProfileMapper.insertSelective(userProfile);
    }
}
