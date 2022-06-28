package com.example.do_an_thang.domain.controllers;

import com.example.do_an_thang.domain.dtos.LoginDTO;
import com.example.do_an_thang.domain.services.AuthenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class AuthenController {
  @Autowired private AuthenService authenService;

  @PostMapping("/indexs")
  public String login(@ModelAttribute("loginDto") LoginDTO loginDTO, HttpSession httpSession) {
    log.error("dd");
    try {
      //      authenService.login(loginDTO);
      int i = 1;
      log.error("dd");

    } catch (Exception e) {
      log.error(e);
    }

    return "home";
  }
}
