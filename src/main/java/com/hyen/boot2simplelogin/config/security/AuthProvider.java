package com.hyen.boot2simplelogin.config.security;

import com.hyen.boot2simplelogin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthProvider implements AuthenticationProvider {


    @Autowired
    RealUserDetailService realUserDetailService;

    /**
     * 입력한 user 정보를 실제 user 정보와 대조한다
     *
     * @param authentication
     * (아이디/패스워드 사용자 정보를 넣고 실제 가입된 사용자인지 체크한후 인증에 성공하면 사용자의 principal과 credential 정보를 Authentication에 담는다.)
     *
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();

        //TODO 실 사용자인지 확인
        try{
            UserDetails userDetails = realUserDetailService.loadUserByUsername(id);
            //TODO usernamePasswordAuthenticationToke 에 id, pw, role 세팅후 반환
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, password, null);
            authenticationToken.setDetails(userDetails);
        }catch(Exception e){

        }
        
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
