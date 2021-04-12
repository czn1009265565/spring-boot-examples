package com.springboot.securityjwt.security.service;

import com.springboot.securityjwt.dao.UserProfileExtendMapper;
import com.springboot.securityjwt.entity.UserProfile;
import com.springboot.securityjwt.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zenan
 * @date: 2021/4/8
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Resource
    private UserProfileExtendMapper userProfileExtendMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileExtendMapper.findByUsername(username);
        if (userProfile == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(userProfile);
    }
}
