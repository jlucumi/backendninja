package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloWorldController
{
  //Nombre del template a encontrar
  @GetMapping("/helloword")
  public String helloWord(){
    //Nombre de la página que está controlando, (vue/angular y demás)
    return "helloword";
  }
}
