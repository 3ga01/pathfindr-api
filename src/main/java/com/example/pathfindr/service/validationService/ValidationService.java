package com.example.pathfindr.service.validationService;

public interface ValidationService {

    void validateToken(String token);

    void validatePassword(String password, String confirmPassword);

    void validateEmail(String email);

    void validateUsername(String username);

}
