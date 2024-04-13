package com.ajes.security;


import com.ajes.service.UserService;

import com.ajes.utility.JwtFilter;
import com.ajes.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserService userService;
	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		System.out.println("SecurityConfiguration.....AuthenticationManagerBuilder...1");
		authenticationManagerBuilder.userDetailsService(userService);

	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		System.out.println("SecurityConfiguration.....HttpSecurity....2");
		httpSecurity.csrf().disable().authorizeRequests()
		        .antMatchers("/ajes/home/").permitAll()
				.antMatchers("/ajes/logging1").permitAll()
				.antMatchers("/ajes/contact/**").permitAll()
				.antMatchers("/ajes/careers/**").permitAll()
				.antMatchers("/ajes/demo/**").permitAll()
				.antMatchers("/ajes/roles/**").permitAll()
				.antMatchers("/ajes/upload").permitAll()
				.antMatchers("/ajes/downloadImage2/**").permitAll()
				.antMatchers("/ajes/user/**").permitAll()
		      .anyRequest().authenticated();
		System.out.println("httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);....3");
		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("SecurityConfiguration....passwordEncoder...4");
		return NoOpPasswordEncoder.getInstance();

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("SecurityConfiguration....authenticationManagerBean....5");
		return super.authenticationManagerBean();
	}

}
