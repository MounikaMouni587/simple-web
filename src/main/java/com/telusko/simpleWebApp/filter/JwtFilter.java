package com.telusko.simpleWebApp.filter;

import com.telusko.simpleWebApp.serviceImpl.JWTService;
import com.telusko.simpleWebApp.serviceImpl.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    ApplicationContext context;
    @Autowired
    private JWTService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader=request.getHeader("Authorization");
        String token=null;
        String name=null;

        if(authHeader!=null && authHeader.startsWith("Bearer "))
        {
            token=authHeader.substring(7);
            name=jwtService.extractUserName(token);
        }
        if(name !=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userDetails=context.getBean(UserServiceImpl.class).loadUserByUsername(name);
            if(jwtService.validateToken(token,userDetails))
            {
                UsernamePasswordAuthenticationToken token1=new UsernamePasswordAuthenticationToken(userDetails,userDetails.getAuthorities());
                token1.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token1);
            }
            filterChain.doFilter(request,response);
        }
    }
}
