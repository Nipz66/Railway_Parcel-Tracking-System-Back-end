package edu.icet.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")  // Load the secret key from application.yml or application.properties
    private String secretKey;

    // Generate a JWT token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", username);
        claims.put("iat", new Date());
        claims.put("exp", new Date(System.currentTimeMillis() + 1000 * 60 *  60));  // Token valid for 1 hour

        return Jwts.builder()
                .setClaims(claims)  // Set claims
                .signWith(SignatureAlgorithm.forName("HS256"), secretKey)  // Sign with HS256 and the secret key
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("sub", String.class);
    }

    // Check if the token is expired
    public boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    private Date extractExpirationDate(String token) {
        JwtParser parser = Jwts.parser()
                .setSigningKey(secretKey) // Set the signing key
                .build(); // Build the parser
        return parser.parseClaimsJws(token) // Parse the token
                .getBody() // Get the claims
                .getExpiration(); // Extract the expiration date
    }
}