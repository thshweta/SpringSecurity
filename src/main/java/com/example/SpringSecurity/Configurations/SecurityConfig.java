package com.example.SpringSecurity.Configurations;

import jakarta.security.auth.message.config.AuthConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean  //it creates the spring container and by default spring security will pick it from there
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /*
       http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
       // http.formLogin(Customizer.withDefaults());                                 //for browser
        http.httpBasic(Customizer.withDefaults());                                  //for POSTMAN(or other API tools)
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        it creates stateless http which will change the session ID everytime
//        we hit the url or send request(will work good with POSTMAN but not browser)
//        hence for the browser we need to disable form login config

     */

        //using builder pattern for the above code
      return http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }



    //for hardcoded values and not using the database
   /* @Bean
    public UserDetailsService userDetailsService(){  //by default UserDetailsService is an interface

        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("Manvi")
                .password("m@123")
                .roles("senior")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("Samiya")
                .password("s@123")
                .roles("lead")
                .build();

        UserDetails user3 = User
                .withDefaultPasswordEncoder()
                .username("Kriti")
                .password("k@123")
                .roles("junior")
                .build();


         return new InMemoryUserDetailsManager(user1,user2,user3);   // and InMemoryUserDetailsManager is the class that implements the interface
    }*/


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //for storing purpose only
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

}
