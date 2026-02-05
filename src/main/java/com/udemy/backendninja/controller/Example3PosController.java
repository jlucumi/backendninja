package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/Example3Pos")
public class Example3PosController
{
  private static final String EXAMPLE3_POST = "showfrm";
  private static final String RESULT_POST = "result";

  /**
   * forma 1 para redireccionar a otra pág cuando se borre parte de la url
   * @return: siempre recibe un path ej "redirect:/Example3Pos/showform"
   */
//  @GetMapping("/")
//  public String redirect()
//  {
//    return "redirect:/Example3Pos/showform";
//  }

  /**
   * forma 2 para redireccionar a otra pág cuando se borre parte de la url
   * @return: siempre recibe un path ej "/Example3Pos/showform"
   */
  @GetMapping("/")
  public RedirectView redirect(){
    return new RedirectView("/Example3Pos/showform");
  }

  /**
   * Método encargado únicamente de mostrar la pantalla
   * @return la pantalla deseada
   */
  @GetMapping("/showform")
  public String showForm(Model model){
    model.addAttribute("person", new Person());
    return EXAMPLE3_POST;
  }

  /**
   * Método encargado de recibir la información de la pantalla showform al presionar el btn,
   * @param person: es el objeto th:object que se envía desde el frm
   *              @ModelAttribute("person"): anotación para recibir el parametro seguido de la notación se debe indicar
   *              el tipo de dato del parametro que llega. y se envía a la siguiente pantalla "result"
   * @return
   */
  @PostMapping("/addperson")
  public ModelAndView addPerson(@ModelAttribute("person") Person person){
    ModelAndView mav = new ModelAndView(RESULT_POST);
    mav.addObject("person", person);
    return mav;
  }


}
