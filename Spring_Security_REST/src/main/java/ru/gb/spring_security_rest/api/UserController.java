package ru.gb.spring_security_rest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.spring_security_rest.model.User;
import ru.gb.spring_security_rest.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/unsecured")
    public String unsecuredPage(){
        return "unsecured";
    }

    @GetMapping("/auth_page")
    public String authenticatedPage(){
        return "authenticated";
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
    public String adminPage(){
        return "admin";
    }

    public String daoTestPage(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
    }

}
