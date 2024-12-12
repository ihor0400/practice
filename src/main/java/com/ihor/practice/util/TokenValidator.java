package com.ihor.practice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Component
public class TokenValidator {

    @Value("${admin.username}")
    private String adminUsername;

    public boolean isValid(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            String[] parts = decodedToken.split(":");

            if (parts.length != 2) {
                return false;
            }

            String username = parts[0];
            Instant expirationTime = Instant.parse(parts[1]);

            if (!adminUsername.equals(username)) {
                return false;
            }

            if (Instant.now().isAfter(expirationTime)) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
