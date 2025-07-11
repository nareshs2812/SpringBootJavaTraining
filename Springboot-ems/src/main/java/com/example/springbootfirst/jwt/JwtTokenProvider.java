package com.example.springbootfirst.jwt;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class JwtTokenProvider{
    @Value("${app.jwt-Secret}");
    private String jwtSecret ;
    @Value("{app.jwt-expiration-milliseconds}");
    private String jwtExpirationDate;
    private Key secretKey(){
        return Keys.hmacshaKeyFor(Decoders.BASE64.decode(jetSecret));
    }

    public String generateToken(Authentication authenticate){
        UserDetails userPrincipal = (UserDetails) authenticate.getPrincipal();

        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(System.+jwtExpirationDate)).
                signWith(jwtSecret,SignatureAlgorithm.HS256).compact();
    }
    public String getUserNameFromToken(String token){
        return Jwts.parseBuilder().setSigningKey(secretKey()).build().parseClaimsJws(token).getBody().getSubject()
    }

    public boolean validateToken(String token){
        try{
            Jwts.parseBuilder().setSigningKey(secretKey()).build().parseClaimsJws(token);
            return true;
        } catch(JwtException | IllegalArgumentException e){
            e.printStackTrace();
        }
        return false;
    }
}