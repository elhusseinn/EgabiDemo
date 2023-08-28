package com.example.ae.Security.Filters;

import com.example.ae.Security.Constants;
import com.example.ae.Utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

    private final AuthenticationProvider authenticationProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userName = "";
        String password = "";
        String uri = request.getRequestURI();
        String header = request.getHeader(Constants.AUTH_HEADER);
        try {
            if(header == null){
                throw new RuntimeException("Missing header");
            }
            if(header.startsWith(Constants.BASIC_TOKEN_PREFIX)){
                header = StringUtils.delete(header, Constants.BASIC_TOKEN_PREFIX);
                String[] creds = AuthUtils.decodedBase64(header);
                userName = creds[0];
                password = creds[1];
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                Authentication authenticate = authenticationProvider.authenticate(authenticationToken);
                System.out.println("authenticate = " + authenticate.isAuthenticated());
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                filterChain.doFilter(request,response);
            }
            if(header.startsWith(Constants.BEARER_TOKEN_PREFIX) && !uri.endsWith(Constants.SIGN_IN_URI_ENDING)){
                // every endpoint that wants to be secured by JWT except the signIn endpoint

                String token = StringUtils.delete(header, Constants.BEARER_TOKEN_PREFIX); // strip the token
                if(!AuthUtils.isJWTTokenValid(token)){
                    filterChain.doFilter(request, response);
                }
                userName = AuthUtils.getUsernameFromJWTUserToken(token);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName,null);
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

