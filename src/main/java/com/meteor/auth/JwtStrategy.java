package com.meteor.auth;

import com.meteor.schema.Meteor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtStrategy {
    public Map<String, String> generateToken(Meteor user) {
        byte[] keyBytes = Decoders.BASE64.decode("secret");
        Key key = Keys.hmacShaKeyFor(keyBytes);
        String jwtToken = Jwts.builder().setSubject(user.getName())
                .setIssuedAt(new Date())
                .signWith(key, SignatureAlgorithm.HS256)
           .compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        String message = "Login Successful";
        jwtTokenGen.put("token", jwtToken);
        jwtTokenGen.put("message", message);
        System.out.println(jwtTokenGen);
        return jwtTokenGen;
    }

    public String verifyToken(String token) {
        byte[] keyBytes = Decoders.BASE64.decode("secret");
        Key key = Keys.hmacShaKeyFor(keyBytes);
        Claims claims = Jwts.
                parser().
                setSigningKey("secret").parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
