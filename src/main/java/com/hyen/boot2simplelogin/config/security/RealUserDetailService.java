package com.hyen.boot2simplelogin.config.security;

import com.hyen.boot2simplelogin.web.domain.User;
import com.hyen.boot2simplelogin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * 유저가 로그인을 하게되면 UserDetailsService의 loadUserByUsername으로 유저를 조회해
 * AuthencationProvider로 리턴해주고
 * AuthencationProvider의 authenticate메소드에서 유저가 입력한 비번과 대조하게된다.
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
