package com.example.newswatchdog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

           http
                .authorizeHttpRequests((requests) -> requests

                        .requestMatchers("/index").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers( "/login").permitAll()
                        .requestMatchers(  "/","/userconsole").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/index")
                        .loginProcessingUrl("/login")
                       //  .defaultSuccessUrl("/userconsole")
                )
                   .logout((logout) -> logout.permitAll());
               //    .sessionManagement()
               //   .invalidSessionUrl("/index")
               //    .maximumSessions(1)
              //     .maxSessionsPreventsLogin(true)
              //     .sessionRegistry(sessionRegistry());

        return http.build();

    }

    @Bean(name = "sessionRegistry")
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    /*
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/","/userconsole").hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .formLogin((form) -> form
                       .loginPage("/login")
                        .failureUrl("/login-error")
                        .permitAll()

               )
                .logout((logout) -> logout.permitAll());



        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("1")
                        .password("1")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

     */

}
