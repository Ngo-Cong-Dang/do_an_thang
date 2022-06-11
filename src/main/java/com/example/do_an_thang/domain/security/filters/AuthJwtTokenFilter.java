package com.example.do_an_thang.domain.security.filters;

import com.example.do_an_thang.domain.ModelMapper;
import com.example.do_an_thang.domain.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthJwtTokenFilter extends OncePerRequestFilter {

  @Autowired private JwtUtils jwtUtils;
  @Autowired private ModelMapper modelMapper;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {}
}
