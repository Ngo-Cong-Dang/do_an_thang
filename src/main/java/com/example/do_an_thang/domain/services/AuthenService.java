package com.example.do_an_thang.domain.services;

import com.example.do_an_thang.domain.data.TokenInfo;
import com.example.do_an_thang.domain.dtos.LoginDTO;
import com.example.do_an_thang.domain.entities.Account;
import com.example.do_an_thang.domain.repositories.AccountRepository;
import com.example.do_an_thang.domain.responses.JwtResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class AuthenService {
  @Autowired private AccountRepository accountRepository;

  @Value("${jwt.publicKey}")
  private String publicKey;

  @Value("${jwt.privateKey}")
  private String privateKey;

  //  @PostMapping("keyPair")
  //  public KeyPairResponse getRsaKeyPair() throws NoSuchAlgorithmException {
  //    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
  //    generator.initialize(1024);
  //
  //    KeyPair kp = generator.generateKeyPair();
  //    PublicKey publicKey = kp.getPublic();
  //    PrivateKey privateKey = kp.getPrivate();
  //
  //    String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
  //    String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
  //
  //    KeyPairResponse response = new KeyPairResponse();
  //    response.setPrivateKey(encodedPrivateKey);
  //    response.setPublicKey(encodedPublicKey);
  //
  //    return response;
  //  }

  public Boolean checkExistUser(TokenInfo info) {
    Account account = accountRepository.findAccountById(info.getId());
    return account != null;
  }

  public JwtResponse login(LoginDTO loginaccount)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    Account account = accountRepository.findByUsername(loginaccount.getUsername());
    if (account == null) {
      return new JwtResponse();
    }
    if (!account.getPassword().equals(loginaccount.getPassword())) {
      return new JwtResponse();
    }
    return new JwtResponse(createToken(privateKey, account));
  }

  private static String createToken(String privateKeyString, Account account)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    byte[] keyBytes = Base64.getDecoder().decode(privateKeyString);
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory fact = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = fact.generatePrivate(keySpec);

    String token = "";
    if (account.getAvatarUrl() != null && account.getFullName() != null) {

      Map<String, Object> claims = new HashMap<>();
      claims.put("id", account.getId());
      claims.put("username", account.getUsername());
      claims.put("type", account.getType());

      log.debug(claims);
      token =
          Jwts.builder()
              .setClaims(claims)
              .setExpiration(Date.from(ZonedDateTime.now().plusHours(5).toInstant()))
              .signWith(SignatureAlgorithm.RS256, privateKey)
              .compact();
    }
    return token;
  }
}
