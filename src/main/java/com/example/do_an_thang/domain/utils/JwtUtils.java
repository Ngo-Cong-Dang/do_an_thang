package com.example.do_an_thang.domain.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
@Log4j2
public class JwtUtils {

  @Value("${jwt.publicKey}")
  private String publicKey;

  public boolean validateJwtToken(String token) {
    log.debug("===========publicKey: " + publicKey);

    try {
      byte[] data = Base64.getDecoder().decode((publicKey));
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(data);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(keySpec);

      Algorithm algorithm = Algorithm.RSA256(publicKey, null);
      JWTVerifier verifier = JWT.require(algorithm).build();

      DecodedJWT jwt = JWT.decode(token);
      verifier.verify(jwt);

      return true;
    } catch (SignatureException e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException | NoSuchAlgorithmException e) {
      log.error("JWT claims string is empty: {}", e.getMessage());
    } catch (InvalidKeySpecException e) {
      log.error("InvalidKeySpecException: {}", e.getMessage());
    } catch (JWTDecodeException e) {
      log.error("JWTDecodeException: {}", e.getMessage());
    } catch (SignatureVerificationException e) {
      log.error("SignatureVerificationException: {}", e.getMessage());
    }

    return false;
  }

  public Claims getInfo(String token) {
    log.debug("========public key1: " + publicKey);

    try {

      byte[] data = Base64.getDecoder().decode((publicKey));
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(data);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(keySpec);
      log.debug("========public key2: " + publicKey);

      return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();
    } catch (Exception e) {
      return null;
    }
  }

  public String getUserId(String token) {
    try {
      byte[] data = Base64.getDecoder().decode((publicKey));
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(data);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      RSAPublicKey publicKey = (RSAPublicKey) kf.generatePublic(keySpec);

      return Jwts.parser()
          .setSigningKey(publicKey)
          .parseClaimsJws(token)
          .getBody()
          .get("userId", String.class);
    } catch (Exception e) {
      return null;
    }
  }
}
