package com.ejemplos.security;

import java.security.Key;
import java.sql.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
@Value("${jwt.secret.key}")
private String secretKey;

@Value("${jwt.time.expiration}")
private String timeExpiration;



//Generar Token de acceso
public String generateAccessToken(String username) {
	return Jwts.builder()
			.setSubject(username)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
			.signWith(getSignatureKey(),SignatureAlgorithm.HS256)
			.compact();
}

//Validar el token de acceso
public boolean isTokenValid(String token) {
	try {
		Jwts.parserBuilder()
		.setSigningKey(getSignatureKey())
		.build()
		.parseClaimsJws(token)
		.getBody();
		return true;
	}catch(Exception e) {
		return false;
	}
}


//Obtener el username del token
public String getUserNameFromToken(String token) {
	return getClaim(token,Claims::getSubject);
}

//Obtener un solo claim
public <T> T getClaim(String token,Function<Claims,T> claimsTFunction) {
	Claims claims=extractAllClaims(token);
	return claimsTFunction.apply(claims);
	
}


//Obtener todos los claims del token
public Claims extractAllClaims(String token) {
	return Jwts.parserBuilder()
			.setSigningKey(getSignatureKey())
			.build()
			.parseClaimsJws(token)
			.getBody();
			
}


//Obtener firma del Token
public Key getSignatureKey() {
	byte[] keyBytes= Decoders.BASE64.decode(secretKey);
	return Keys.hmacShaKeyFor(keyBytes);
}
}
