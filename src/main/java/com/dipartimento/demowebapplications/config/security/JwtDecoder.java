package com.dipartimento.demowebapplications.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;
import java.util.Map;

public class JwtDecoder {

    public static  Map<String, Object> decodeJWT(String jwt) {
        try {
            // Split del token in Header, Payload e Signature
            String[] parts = jwt.split("\\.");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Token JWT non valido");
            }

            // Decodifica il payload (seconda parte del JWT)
            String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

            // Converte il payload JSON in una mappa
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(payload, Map.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Errore nella decodifica del JWT", e);
        }
    }






//    private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey"; // Deve essere di almeno 256 bit
//
//    private final Key key;
//
//    public JwtDecoder() {
//        // Genera la chiave a partire dal segreto
//        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//    }
//
//    public Claims decodeJWT(String jwt) {
//        try {
//            // Decodifica e valida il JWT
//            return Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(jwt)
//                    .getBody();
//        } catch (SignatureException e) {
//            throw new IllegalArgumentException("Token JWT non valido", e);
//        }
//    }
}

