package com.example.lab_session3_4.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenUtil {

    // Token có hạn trong 7 ngày kể từ thời điểm tạo, thời gian tính theo giây
    @Value("${jwt.duration}")
    public Integer duration;

    // Key này được dùng dể mã hóa và giải mã
    @Value("${jwt.secret}")
    private String secret;

    //Sinh token
    public JwtGenerated generateToken(UserDetails userDetails) {
        //Lưu thông tin Authorities của user vào claims
        Map<String, Object> claims = new HashMap<>();

        //1. Định nghĩa các claims: issuer, expiration, subject, id
        //2. Mã hóa token sử dụng thuật toán HS512 và key bí mật
        //3. Convert thành chuỗi URL an toàn
        //4. Cộng chuỗi đã sinh ra với tiền tố Bearer

        Date expiredIn = new Date(System.currentTimeMillis() + duration * 1000);

        return JwtGenerated.builder()
                .accessToken(Jwts.builder()
                        .setClaims(claims)
                        .setSubject(userDetails.getUsername())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(expiredIn)
                        .signWith(SignatureAlgorithm.HS256, secret).compact())
                .expiredIn(expiredIn)
                .build();
    }

    public Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token" + ex.getMessage(), ex);
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token" + ex.getMessage(), ex);
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token" + ex.getMessage(), ex);
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty." + ex.getMessage(), ex);
        }
        return false;
    }
}
