package com.medicine.userService.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64.Decoder;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.medicine.userService.model.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.*;

@Service
public class JwtService {

    private final String SECRET_KEY = "228e78c388a8f5de5c4b6828f25736810e83f5131e8ae6e3fc4208f64e66c6f0";

    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token,UserDetails user)
    {
        String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
        
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public<T> T extractClaim(String token,Function<Claims,T> resolver)
    {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        Key key = getSigninKey();
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public String generateToken(Users user)
    {
        String token = Jwts.builder()
        .setSubject(user.getUsername()).
        setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 24*60*60*100))
        .signWith(null, getSigninKey())
        .compact();
        return token;
    }

    private SecretKey getSigninKey(){

        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256");


    }

}
