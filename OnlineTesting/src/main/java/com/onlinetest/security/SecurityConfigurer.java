package com.onlinetest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.onlinetest.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public JwtAuthenticationEntryPoint jwtAuthEntryPoint() {
		return new JwtAuthenticationEntryPoint();
	}

	/*
	 * configure AuthenticationManager so that it knows from where to load user for
	 * matching credentials and also Use BCryptPasswordEncoder for password encoding
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        		.csrf().disable()
        		.authorizeRequests()
                .antMatchers("/", "/signup","/signin","/v2/api-docs", 
        	            "/swagger-resources/**",  
        	            "/swagger-ui.html", 
        	            "/webjars/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
