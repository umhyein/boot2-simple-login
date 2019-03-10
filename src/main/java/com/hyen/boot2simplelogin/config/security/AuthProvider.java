package com.hyen.boot2simplelogin.config.security;

import com.hyen.boot2simplelogin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
public class AuthProvider implements AuthenticationProvider {


    @Autowired
    UserService userService;

    /**
     * authenticate메소드에서 authentication 객체를 리턴해야한다.
     * authentication 객체는 스프링에서 구현해놓은은 UsernamePasswordAuthenticationToken 사용해도 무방하다.
     * UsernamePasswordAuthenticationToken(UserDetailsService.loadUserByUsername(String username),null(보통은널),권한) 을 생성하게되면
     * Aunthetication이 생성되어지고 최종적으로 이것을 리턴해주게되면 security 인증이 끝나게 된다.
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

        //TODO usernamePasswordAuthenticationToke 에 id, pw, role 세팅후 반환
        //UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(id, password, )

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
