package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {
	@Bean
	public UserDetailsService users(PasswordEncoder encoder) {
	 UserDetails admin = User.builder()
	 .username("jhansi2")
	 .password( encoder. encode("1234"))
	 .roles("admin")
	 .build();
	 
	
	 UserDetails user= User.builder()
	 .username("prashu")
	 .password(encoder. encode("0987"))
	 .roles("user")
	 .build();
	 
	 UserDetails admin1 = User.builder()
			 .username("jhansi3")
			 .password( encoder. encode("3333"))
			 .roles("admin1")
			.build();
	 UserDetails user1= User.builder()
			 .username("prashu2")
			 .password(encoder. encode("2222"))
			 .roles("user2")
			 .build();
			 
		return new InMemoryUserDetailsManager(admin,user,admin1,user1);
		
		
	}
@Bean
public PasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder();
}
 @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	 DefaultSecurityFilterChain  defaultSecurityFilterChain  = http
			 .csrf(csrf->csrf.ignoringRequestMatchers("/admin/**"))
			 .authorizeHttpRequests(authorize->authorize
					 .requestMatchers("/admin/**").permitAll()
					 .requestMatchers("/user/**").authenticated()
					 .anyRequest().authenticated()
					 ).httpBasic(Customizer.withDefaults())  
			 .build();
			 
	return  defaultSecurityFilterChain;
	   
   }
 @Bean
 public Docket api() {
     
     return new Docket(DocumentationType.SWAGGER_2)
             .select()
             .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
             .paths(PathSelectors.any())
             .build();
     
 }
}


