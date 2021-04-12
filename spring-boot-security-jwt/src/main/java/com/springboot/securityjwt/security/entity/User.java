package com.springboot.securityjwt.security.entity;

import com.springboot.securityjwt.entity.UserProfile;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zenan
 * @date: 2021/4/8
 */
@Data
public class User implements UserDetails {

    private UserProfile userProfile;

    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) return authorities;

        this.authorities = Arrays.stream(userProfile.getRoles().split(","))
                .filter(StringUtils::hasLength)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return userProfile.getPassword();
    }

    @Override
    public String getUsername() {
        return userProfile.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userProfile.getEnabled();
    }

    public User() {
    }

    public User(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
