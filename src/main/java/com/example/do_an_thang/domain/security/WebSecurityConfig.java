package com.example.do_an_thang.domain.security;

import com.example.do_an_thang.domain.security.filters.AuthJwtTokenFilter;
import com.example.do_an_thang.domain.security.filters.UnauthorizedHandlerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired private UnauthorizedHandlerFilter unauthorizedHandlerFilter;

  @Bean
  public AuthJwtTokenFilter authenticationJwtTokenFilter() {
    return new AuthJwtTokenFilter();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(unauthorizedHandlerFilter)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.authorizeRequests()
        .antMatchers(
            "/v1/gami/auth/**",
            "/v1/gami/it/**",
            "/v1/gami/it/leaderboard/**",
            "/v1/gami/it/tasks/**",
            "/v1/gami/it/campaigns/**",
            "/v1/gami/it/campaign/collections/**",
            "/v1/addLogs/**",
            "/v1/gami/it/games/**",
            "/v1/gami/it/users/**",
            "/v1/gami/public/gami/healthcheck/**")
        .permitAll();

    http.authorizeRequests().anyRequest().authenticated();

    http.addFilterBefore(
        authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}
