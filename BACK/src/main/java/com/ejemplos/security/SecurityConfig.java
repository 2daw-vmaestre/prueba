//package com.ejemplos.security;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//	@Configuration
//	public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//		@Autowired
//		 UserDetailsServiceImpl userDetailsService;
//		 @Autowired
//		 JwtUtils jwtUtils;
//		 
//		
//		 
//		    SecurityFilterChain securityFilterChain(HttpSecurity http,AuthenticationManager authenticationManager) throws Exception {
//		    	JwtAuthenticationFilter jwtAuthenticacionFilter=new JwtAuthenticationFilter(jwtUtils);
//		    	jwtAuthenticacionFilter.setAuthenticationManager(authenticationManager);
//		    	jwtAuthenticacionFilter.setFilterProcessesUrl("/login");
//		    	return http.csrf().disable()
//		            .authorizeRequests()
//		            .anyRequest().authenticated()
//		            .and()
//		            .httpBasic()
//		            .and()
//		            .sessionManagement()
//		            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		            .and()
//		            .addFilter(jwtAuthenticacionFilter)
//		            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationToken.class)
//		            
//		    		
//		    		.build();
//		    }
//		
////		    @Bean
////		    public UserDetailsService userDetailsService() {
////		        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////		        String encodedPassword = passwordEncoder().encode("admin");
////		        manager.createUser(User.withUsername("admin")
////		                .password(encodedPassword)
////		                .roles()
////		                .build());
////		        return manager;
////		    }
//
//		    
//
//		    @Bean
//		    public PasswordEncoder passwordEncoder() {
//		        return new BCryptPasswordEncoder();
//		    }
//		    
//		    
//		    @Bean
//		    AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder)throws Exception{
//		    	return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
//		    			.userDetailsService(userDetailsService)
//		    			.passwordEncoder(passwordEncoder)
//		    			.and().build();
//		    	
//		    }
//		
//	
//	}
//	
//
//
