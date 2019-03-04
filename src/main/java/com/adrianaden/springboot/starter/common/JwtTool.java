package com.adrianaden.springboot.starter.common;

import com.adrianaden.springboot.starter.entity.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTool {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration.second}")
    private Long jwtExpiration;

    /**
     * generate token with payload
     * @param person the payload of token
     *
     * @return hashed token
     */
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
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + jwtExpiration * 1000);
    }
}
