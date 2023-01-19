package ru.gb.spring_security.configs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.gb.spring_security.services.UserService;

@Configuration
@RequiredArgsConstructor
@Slf4j
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        log.info("Dao Authentication Provider");

        return http.
                authorizeHttpRequests().
//                requestMatchers("/auth_page/**").authenticated().
//                requestMatchers("/user_info").authenticated().
                requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERADMIN").
                anyRequest().permitAll().
                and().formLogin().
                and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID").
                and().build();
    }

/*    @Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}100")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}101") //префикс {noop} в пароле не участвует, но означает, что это пароль в чистом виде, Хеш пароль обозначается префиксом {bcrypt}
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }
}
