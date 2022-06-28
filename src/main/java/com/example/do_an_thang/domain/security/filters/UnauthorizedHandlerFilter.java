// package com.example.do_an_thang.domain.security.filters;
//
// import com.example.do_an_thang.domain.utils.JsonParser;
// import lombok.extern.log4j.Log4j2;
// import org.springframework.http.MediaType;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.stereotype.Component;
//
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.util.HashMap;
// import java.util.Map;
//
// @Component
// @Log4j2
// public class UnauthorizedHandlerFilter implements AuthenticationEntryPoint {
//  @Override
//  public void commence(
//      HttpServletRequest request,
//      HttpServletResponse response,
//      AuthenticationException authException)
//      throws IOException, ServletException {
//    log.error("Unauthorized error: {}", authException.getMessage());
//
//    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//    final Map<String, Object> body = new HashMap<>();
//    body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//    body.put("error", "Unauthorized");
//    body.put("message", authException.getMessage());
//    body.put("path", request.getServletPath());
//
//    JsonParser.getMapper().writeValue(response.getOutputStream(), body);
//  }
// }
