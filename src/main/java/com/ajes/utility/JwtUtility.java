	package com.ajes.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service

public class JwtUtility {

	private final int hours = 10;
	private final int minutes = 10;
	private final int seconds = 10;
	public final long jwtTokenValidityTiming = hours * minutes * seconds;

	private String secretKey = "ajes";

	public String generateJwtToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		System.out.println("generateJwtToken");
		return doGenerateToken(claims, userDetails.getUsername());
	}
	///////////////// containes JWT Algro+PayLoad+secretecode then retrun to above
	///////////////// fun//////////////////

	final String doGenerateToken(Map<String, Object> claims, String subjects) {
		System.out.println("doGenerateToken");
		String jwtToken = Jwts.builder().setClaims(claims).setSubject(subjects)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() +(jwtTokenValidityTiming * 1000)))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();

		System.out.println("jwtToken...:" + jwtToken);
		return jwtToken;
	}

	private Claims getAllCailmsFromToken(String token) {
		System.out.println("getAllCailmsFromToken");
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		System.out.println("Claims:...."+claims );
		
		return claims;

	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		System.out.println("getClaimFromToken");
		Claims claims = getAllCailmsFromToken(token);
		return claimsResolver.apply(claims);

	}

	private Date getexpirationDateFromToken(String token) {
		// TODO Auto-generated method stub
		System.out.println("getexpirationDateFromToken");
		
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public String getUsernameFromToken(String token) {
		System.out.println("getUsernameFromToke");
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Boolean isTokenExpire(String token) {
		System.out.println("isTokenExpire");
		Date expirationDate = getexpirationDateFromToken(token);
		return expirationDate.before(new Date());

	}
	public Boolean valiDateToken(String token, UserDetails userDetails) {
		System.out.println("valiDateToken");
		String userName = getUsernameFromToken(token);
		if (userName.equals(userDetails.getUsername()) && !isTokenExpire(token)) {
			System.out.println("valiDateToken..true");
			return true;
		} else {
			System.out.println("valiDateToken..false");
			return false;
		}
	}

}
