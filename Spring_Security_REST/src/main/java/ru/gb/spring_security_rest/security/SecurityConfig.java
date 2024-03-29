package ru.gb.spring_security_rest.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.gb.spring_security_rest.api.MainFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(MainFilter filter, HttpSecurity http) throws Exception{
        return http.
                authorizeHttpRequests().
                requestMatchers("/api/v1/cart/**").authenticated().
                anyRequest().permitAll().
//                and().formLogin().
                and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class).
                build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return webSecurity -> webSecurity.ignoring().requestMatchers("/auth/**", "/api/v1/products/**");
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.builder()
                .username("user")
                .password("pass")
                .authorities("ADMIN", "MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider... providers){
        return new ProviderManager(providers);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        return new StandardAuthenticationProvider();
    }
}
