package com.example.ae.Services;

import com.example.ae.POJO.UserPOJO;
import com.example.ae.Utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private UserDetailsService userDetailsService;
    public String login(UserPOJO userPOJO) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userPOJO.getName(), userPOJO.getPassword());
        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource()
        );
        Authentication authenticate = authenticationProvider.authenticate(authenticationToken); // auth the user

        if(authenticate.isAuthenticated()){ // if user is auth
            return AuthUtils.generateJWTUserToken(userPOJO.getName());
        }
        throw new Exception("Authentication failed");

    }

}
