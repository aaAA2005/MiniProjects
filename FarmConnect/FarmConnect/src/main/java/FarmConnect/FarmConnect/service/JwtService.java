package FarmConnect.FarmConnect.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    // 32+ simvol uzunluğunda secret
    private static final String SECRET = "farmconnectfarmconnectfarmconnect123"; 
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes()); // Key obyektinə çevir

    public String generateToken(String gmail) {
        return Jwts.builder()
                .setSubject(gmail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 saat
                .signWith(key, SignatureAlgorithm.HS256) // Key istifadə et
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()           // parserBuilder() istifadə et (0.11+ versiyada)
                .setSigningKey(key)           // Key obyektini ötür
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

