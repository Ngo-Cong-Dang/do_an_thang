package com.example.do_an_thang.domain.controllers;

import com.example.do_an_thang.domain.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
@Log4j2
public class HomeController {

  @Autowired private ProductService productService;

  @GetMapping()
  public String home(Model model) {
    log.error(productService.findNewProduct().size());
    model.addAttribute("products", productService.findNewProduct());
    return "shop-index";
  }
}
