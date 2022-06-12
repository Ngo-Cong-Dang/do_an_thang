package com.example.do_an_thang.domain.security.filters;

import com.example.do_an_thang.domain.ModelMapper;
import com.example.do_an_thang.domain.repositories.AccountRepository;
import com.example.do_an_thang.domain.security.UserDetailsImpl;
import com.example.do_an_thang.domain.services.AuthenService;
import com.example.do_an_thang.domain.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthJwtTokenFilter extends OncePerRequestFilter {

  @Autowired private JwtUtils jwtUtils;
  @Autowired private AccountRepository accountRepository;
  @Autowired private ModelMapper modelMapper;
  @Autowired private AuthenService authenService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String token = request.getHeader("token");
    Claims claims = jwtUtils.getInfo(token);

    UserDetailsImpl userDetails = new UserDetailsImpl(claims);

    if (authenService.checkExistUser(modelMapper.toTokenInfo(userDetails))) {
      UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
  }
}
