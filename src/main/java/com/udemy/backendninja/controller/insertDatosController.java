package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/insert")
public class insertDatosController
{
  public static final String INSERT_VIEW = "insertDatos";

  /**
   * Paso de valores al front por medio de parametros
   * @param model: parametro que llega o se construira
   * @return
   */
  @GetMapping("/exampleString")
  public String exampleString(Model model){
    model.addAttribute("name", "Jeinsson");
    return INSERT_VIEW;
  }

  /**
   * Paso de valores al fron por medio de objetos
   * @return
   */
  @GetMapping("/exampleNAV")
  public ModelAndView exampleNAV(){
    //Se instancia un obj ModelAndView y se agregan los valores
    ModelAndView mav = new ModelAndView(INSERT_VIEW);
    mav.addObject("name", "Andres");
    return mav ;//Pantalla a la que se navegará
  }

}
