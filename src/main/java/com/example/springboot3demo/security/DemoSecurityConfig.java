package com.example.springboot3demo.security;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager( DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    /*public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                                .username("john")
                                .password("{noop}john123")
                                .roles("EMPLOYEE")
                                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}mary123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails david = User.builder()
                .username("david")
                .password("{noop}david123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}susan123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, david, susan);

    }

     */


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(config -> config
                                            .requestMatchers( HttpMethod.GET, "/api/students").hasRole("EMPLOYEE")
                                            .requestMatchers( HttpMethod.GET, "/api/students/**").hasRole("EMPLOYEE")
                                            .requestMatchers( HttpMethod.POST, "/api/students").hasRole("MANAGER")
                                            .requestMatchers( HttpMethod.PUT, "/api/students").hasRole("MANAGER")
                                            .requestMatchers( HttpMethod.DELETE, "/api/students").hasRole("ADMIN")
        );

       // Use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
        //disable CSRF
        //In general, not required for stateless REST APIs that use POST, PUT, DELETE, and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


}
