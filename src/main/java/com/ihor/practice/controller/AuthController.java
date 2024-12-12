package com.ihor.practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Base64;
import java.util.Date;

@Controller
public class AuthController {

    @Value("${admin.username}")
    private String validUsername;

    @Value("${admin.password}")
    private String validPassword;



    public boolean isTokenValid(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] parts = decodedToken.split(":");
            String username = parts[0];
            long expirationTime = Long.parseLong(parts[1]);

            if (username.equals(validUsername) && new Date().getTime() < expirationTime) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
