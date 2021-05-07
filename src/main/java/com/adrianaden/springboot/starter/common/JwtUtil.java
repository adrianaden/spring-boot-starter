package com.adrianaden.springboot.starter.common;

import com.adrianaden.springboot.starter.entity.Person;
import com.adrianaden.springboot.starter.properties.ApplicationProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Autowired
    private ApplicationProperties applicationProperties;

    public String generateToken(Person person) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("jti", person.getId());
        claims.put("personId", person.getId());
        claims.put("personFirstName", person.getFirstName());
        claims.put("personLastName", person.getLastName());
        claims.put("audience", "web");
        claims.put("created", new Date());

        return generateToken(claims);
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(applicationProperties.getJwt().getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, applicationProperties.getJwt().getSecret())
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + applicationProperties.getJwt().getExpiration() * 1000);
    }
}
