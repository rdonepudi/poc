package com.osi.urm.security.util;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

/*import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.osius.tokengeneration.security.transfer.JwtUserDto;*/

@Component
public class TokenGenerator {

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
   
	
	public String generateToken(String username){
				String randString=UUID.randomUUID().toString();
				String stringToBeEncoded = username + randString;
				byte[] firstByteArray = Base64.encodeBase64(stringToBeEncoded.getBytes());
				String primaryEncodedString = new String(firstByteArray);
				byte[] secoundByteArray = Base64.encodeBase64(primaryEncodedString.getBytes());
				String secoundaryEncodedString = new String(secoundByteArray);
				return secoundaryEncodedString;
				
	}
	
	/* public static String generateToken(JwtUserDto u, String secret) {
    Claims claims = Jwts.claims().setSubject(u.getUsername());
    claims.put("userId", u.getId() + "");
    claims.put("role", u.getRole());

    return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
}*/

    /*public static void main(String[] args) {

    	System.out.println(generateToken("admin"));
        
    }*/
    
    
}
