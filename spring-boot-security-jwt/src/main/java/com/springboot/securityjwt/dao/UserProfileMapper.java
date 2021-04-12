package com.springboot.securityjwt.dao;

import com.springboot.securityjwt.entity.UserProfile;
import com.springboot.securityjwt.entity.UserProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserProfileMapper {
    long countByExample(UserProfileExample example);

    int deleteByExample(UserProfileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserProfile record);

    int insertSelective(UserProfile record);

    List<UserProfile> selectByExample(UserProfileExample example);

    UserProfile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    int updateByExample(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    int updateByPrimaryKeySelective(UserProfile record);

    int updateByPrimaryKey(UserProfile record);
}