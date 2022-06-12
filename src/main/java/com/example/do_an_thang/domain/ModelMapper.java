package com.example.do_an_thang.domain;

import com.example.do_an_thang.domain.data.TokenInfo;
import com.example.do_an_thang.domain.security.UserDetailsImpl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {
  TokenInfo toTokenInfo(UserDetailsImpl userDetails);
}
