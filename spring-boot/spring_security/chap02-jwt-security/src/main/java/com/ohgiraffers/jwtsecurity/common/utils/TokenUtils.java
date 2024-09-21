package com.ohgiraffers.jwtsecurity.common.utils;


import com.ohgiraffers.jwtsecurity.user.entity.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * 토큰을 관리하기 위한 utils 모음 클래스
 * */
@Component
public class TokenUtils {
    private static String jwtSecretKey;
    private static Long tokenValidateTime;


    @Value("${jwt.key}")
    public void setJwtSecretKey(String jwtSecretKey) {
        TokenUtils.jwtSecretKey = jwtSecretKey;
    }
    @Value("${jwt.time}")
    public void setTokenValidateTime(Long tokenValidateTime) {
        TokenUtils.tokenValidateTime = tokenValidateTime;
    }






    /**
     * description. header의 token을 분리하는 메소드
     *
     * @param header (Authrization의 header값)
     * @return String (Authrization의 token 부분)
     */
    public static String splitHeader(String header) {
        if (!header.equals("")) {     // 빈 문자열일 경우
            return header.split(" ")[1];        // 헤더의 첫번째 공백 이후만 잘라내기
        } else {
            return null;    // 빈값이 아닐 경우 null 리턴
        }
    }


    /**
     * description. 토큰이 유효한지 확인하는 메소드
     *
     * @param token
     * @return boolean : 유효 판단 여부
     */
    public static boolean isValidToken(String token) {
        /* 토큰 복호화 */
        try {
            Claims claims = getClaimsFromToken(token);
            return true;
        } catch (ExpiredJwtException e){
            e.printStackTrace();
            return false;
        } catch (JwtException e){
            e.printStackTrace();
            return false;
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }


    /**
     * description. 토큰을 복호화 하는 메소드
     *
     * @param token
     * @return Claims
     */
    public static Claims getClaimsFromToken(String token){
        return Jwts.parser()    // 토큰 파싱하는 메소드
                .setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecretKey))   // 시크릿 키를 넣은 암호화 방식
                .parseClaimsJws(token)  // 분리
                .getBody(); // payload 에 해당하는 정보 반환
    }

    /**
     * description. 토큰을 생성하는 메소드
     *
     * @param user
     * @return token (String)
     */
    public static String generateJwtToken(User user) {
        Date expireTime = new Date(System.currentTimeMillis() + tokenValidateTime);

        JwtBuilder builder = Jwts.builder()
                .setHeader(createHeader())
                .setClaims(createClaims(user))
                .setSubject("ohgiraffers token" + user.getUserNo())
                .signWith(SignatureAlgorithm.HS256, createSignature())
                .setExpiration(expireTime);
        return builder.compact();
    }



    /**
     * description. 토큰의 header를 설정하는 메소드
     *
     * @return Map<String, Object> (header의 설정 정보)
     */
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("type", "jwt");  // 타입 json web token
        header.put("alg", "HS256"); // 알고리즘 암호화 방식
        header.put("date", System.currentTimeMillis()); // 만들어진 시간 정보
        return header;
    }


    /**
     * description. 사용자 정보를 기반으로 claim을 생성하는 메소드
     *
     * @param user (사용자 정보)
     * @return Map<String, Object> (claims 정보)
     */
    private static Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("userName", user.getUserName());
        claims.put("Role", user.getRole());

        return claims;
    }


    /**
     * description. JWT 서명을 발급하는 메소드
     *
     * @return Key : SecretKeySpec
     */
    private static Key createSignature() {
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey);
        return new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

}
