package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;

import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/Example3Pos")
public class Example3PosController
{
  //Para el manejo de log
  //  private static final String LOGGER = LogFactory.getLog(Example3PosController.class);
  private static final Log LOGGER = LogFactory.getLog(Example3PosController.class);


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
//    LOGGER.info("info trace");
//    LOGGER.warn("warn trace");
//    LOGGER.error("error trace");
//    LOGGER.debug("debug trace");

    model.addAttribute("person", new Person());
    //int i = 6 /0;//Se creó para disparar el error 500 desde la clase ErrorControllerAdvice
    return EXAMPLE3_POST;
  }

  /**
   * Método encargado de recibir la información de la pantalla showform al presionar el btn,
   * @param person: es el objeto th:object que se envía desde el frm
   *              @ModelAttribute("person"): anotación para recibir el parametro seguido de la notación se debe indicar
   *              el tipo de dato del parametro que llega. y se envía a la siguiente pantalla "result"
   * @valid: permite agregar validaciones de spring
   * BindingResult: lo usará spring para validar los campos. al momento de invocar el método
   * revisará las anotaciones de validación de cada campo y los que no se cumplan los agregará al BindingResult
   *
   * @return
   */
  @PostMapping("/addperson")
  public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
    ModelAndView mav = new ModelAndView();
    if (bindingResult.hasErrors()) {
      mav.setViewName(EXAMPLE3_POST);
    } else {
      mav.setViewName(RESULT_POST);
      mav.addObject("person", person);
    }
    return mav;
//    ModelAndView mav = new ModelAndView(RESULT_POST);
//    mav.addObject("person", person);
//    return mav;

  }


}
