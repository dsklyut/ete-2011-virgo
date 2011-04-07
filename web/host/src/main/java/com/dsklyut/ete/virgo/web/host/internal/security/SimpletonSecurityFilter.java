package com.dsklyut.ete.virgo.web.host.internal.security;

import com.dsklyut.ete.virgo.jpa.security.SecurityHolder;
import com.dsklyut.ete.virgo.jpa.security.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: dsklyut
 * Date: 4/7/11
 * Time: 3:16 PM
 */
public class SimpletonSecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        
        SecurityHolder.set(new User("simpletonUser", "Simple User"));
        try {
            filterChain.doFilter(request, response);
        } finally {
            SecurityHolder.clear();
        }
    }
}
