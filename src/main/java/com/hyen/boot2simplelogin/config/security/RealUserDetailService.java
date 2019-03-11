package com.hyen.boot2simplelogin.config.security;

import com.hyen.boot2simplelogin.web.domain.User;
import com.hyen.boot2simplelogin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * 실제user 정보를 확인하고 실제user를 반환한다.
 */
public class RealUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        User user = userService.findByid(id);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException(String.format("notExist===> %s", id));
        }
        return new RealUserDetails();
    }
}
