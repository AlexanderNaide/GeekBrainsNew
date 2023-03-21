package ru.gb.spring_security_rest.api;

import lombok.Getter;

@Getter
public class AuthRequest {

    private String username;
    private String password;

}
