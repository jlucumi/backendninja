package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

//Definición de Bean
@Controller
@RequestMapping("/example")
public class ExampleController
{
  public static final String EXAMPLE_VIEW = "example";

  /*Versión vieja spring antes de la v4*/
  @RequestMapping(value = "/exampleStr", method = RequestMethod.GET)
  public String exampleStr(){
  return EXAMPLE_VIEW;
  }

  //Misma acción que en la ln14 con menos código
  /*Primera forma de hacer el llamado:
  * Recomiendan su uso, para cuando hay que hacer redirecciones
   *  e insertar pocos datos en el html */
  @GetMapping("/exampleString")
  public String exampleString(){
    return EXAMPLE_VIEW;
  }

  /*Segunda forma de hacer el llamado:
  * Recomiendan su uso, para cuando hay que insertar bastantes
  *  datos en el html*/
  @GetMapping("/exampleNAV")
  public ModelAndView exampleNAV(){
    return new ModelAndView(EXAMPLE_VIEW)  ;//Pantalla a la que se navegará
  }
}
