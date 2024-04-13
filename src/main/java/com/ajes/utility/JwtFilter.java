package com.ajes.utility;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter {

   @Autowired
   private JwtUtility jwtUtility;
	
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
           System.out.println(" JwtFilter doFilterInternal");
		String token = request.getHeader("Authorization");
		

		String username = null;
		if (token != null) {
			 System.out.println(" JwtFilter doFilterInternal..11111");
			username = jwtUtility.getUsernameFromToken(token);
		}
		if (token != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userService.loadUserByUsername(username);
			if (jwtUtility.valiDateToken(token, userDetails)) {
				System.out.println(" JwtFilter doFilterInternal..22222");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, new ArrayList<>());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().equals(request));
				System.out.println(" JwtFilter doFilterInternal..33333");
			}
		}
		System.out.println(" JwtFilter doFilterInternal...44444");
		
		filterChain.doFilter(request, response);
		
		System.out.println(request+"........"+response);		
	}

}
