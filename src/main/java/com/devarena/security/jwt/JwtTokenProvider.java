package com.devarena.security.jwt;

import com.devarena.modules.auth.enums.Roles;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${JWT_SECRET}")
    private String secret;

    @Value("${JWT_EXPIRATION}")
    private Long expiration;

    public String generateToken(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String role = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("");
        return buildToken(user.getUsername(), role, expiration);
    }

    public String generateToken(String email, String role) {
        return buildToken(email, role, expiration);
    }

    private String buildToken(String subject, String role, Long expirationTime) {
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .claim("role", role)
                .signWith(getSecret())
                .compact();
    }

    public SecretKey getSecret() {
        byte[] newSecret = secret.getBytes();
        return Keys.hmacShaKeyFor(newSecret);
    }

    public Claims claims(String token) {
        return Jwts.parser().verifyWith(getSecret())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String getUsernameFromToken(String token) {
        return claims(token).getSubject();
    }

    public Roles getRoleFromToken(String token) {
        Claims claims = claims(token);
        String roleString = claims.get("role", String.class);
        if (roleString == null || roleString.isEmpty()) {
            return Roles.USER;
        }
        String cleanedRole = roleString.replace("ROLE_", "");
        return Roles.valueOf(cleanedRole);
    }

    public boolean validateToken(String token) {
        try {
            claims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}