package com.example.service;

import com.example.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTSecurityToken implements ToenGenerator{
    @Override
    public Map<String, String> generateToen(User user) {
        String webToken=null;

        JwtBuilder jwtBuilder= Jwts.builder();

        webToken=jwtBuilder.setSubject(user.getUsername()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secret").compact();

        Map<String,String> tokenMap=new HashMap<String,String>();
        tokenMap.put("token",webToken);
        tokenMap.put("message","User Successfully LoggedIn");

        return tokenMap;
    }
}
