package com.rajat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rajat.filter.JWTFilter;
import com.rajat.service.impl.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	@Autowired
	UserDetailServiceImpl userDetailsService;
	
	@Autowired
	JWTFilter jwtFilter;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        return http.authorizeHttpRequests(request -> request
//                        .requestMatchers("/public/**").permitAll()
//                        .requestMatchers("/journal/**", "/user/**").authenticated()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
		
//		System.out.println("securityFilterChain called");
//		return http.authorizeHttpRequests(request -> request
//                .requestMatchers("/employee/**").authenticated()
//                .anyRequest().permitAll())
//        .httpBasic(Customizer.withDefaults())
//        .csrf(AbstractHttpConfigurer::disable)
//        .build();
		
		//For Admin role  - postman - auth - Basic Auth
		
//		System.out.println("securityFilterChain called");
//		return http.authorizeHttpRequests(request -> request
//                .requestMatchers("/employee/**","/address/**").authenticated()
//                .requestMatchers("/admin/**").hasRole("Admin")
//                .anyRequest().permitAll())
//        .httpBasic(Customizer.withDefaults())
//        .csrf(AbstractHttpConfigurer::disable)
//        .build();
		
		//For JWT - postman - auth - bearer Token - put generated token
		
		System.out.println("securityFilterChain called");
		return http.authorizeHttpRequests(request -> request
                .requestMatchers("/employee/**","/address/**").authenticated()
                .requestMatchers("/admin/**").hasRole("Admin")
                .anyRequest().permitAll()).csrf(AbstractHttpConfigurer::disable)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        System.out.println("configureGlobal called");
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
}
