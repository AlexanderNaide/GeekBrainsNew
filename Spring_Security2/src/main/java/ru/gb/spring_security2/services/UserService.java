package ru.gb.spring_security2.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import ru.gb.spring_security2.model.Role;
import ru.gb.spring_security2.model.User;
import ru.gb.spring_security2.repository.RoleRepository;
import ru.gb.spring_security2.repository.UserRepository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Bean
    public JdbcUserDetailsManager users(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    @EventListener(ApplicationReadyEvent.class)
    public void generateDataOnStartup(){

        Role userRole = new Role();
        userRole.setName("ROLE_USER");

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");

        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User user = new User();
        user.setUsername("user");
        user.setPassword("$2a$12$odCCUlrDhmdqAOO4tiJcpenIRIJytzswlJDhFvGn60k11ZcBFZMD.");
        user.setEmail("us@us.ru");

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("$2a$12$Srq6zUmVauisVIyW3epziOuD2wM9Sj0iAgL8UkWQtsWXqztmlweTa");
        admin.setEmail("ad@ad.ru");

        user.setRoles(List.of(userRole));
        admin.setRoles(List.of(userRole, adminRole));

        userRepository.save(user);
        userRepository.save(admin);

    }
}
