package com.udemy.backendninja.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Forma de realizar una petición GET con parametros en la url
 */
@Controller
@RequestMapping("/exampleGet")
public class Example2Controller
{
  private  static final String  EXAMPLE2_VIEW = "example2Get";

  /**
   * http://localhost:8080/exampleGet/request1?nm=Jeinsson
   * @RequestParam Especifica (value: el nombre del parametro,
   *                          required: si es requerido true/false,
   *                          defaultValue: Valor por defecto en el caso que no llegue el parametro),
   *                            tipo de dato y nombre del parametro
   *              Si el parametro required es true la página falla si no llega dicho value en la URL
   * @return ruta
   */
  @GetMapping("/request1")
  public ModelAndView request1(@RequestParam(value = "nm", required = false, defaultValue = "Null") String name){
    ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
    //paso del parametro mediante el mav "nm_in_model": nombre usado en la pág html
    mav.addObject("nm_in_model", name);
    return mav;
  }

  /**
   * Paso de parametros directamente en el path http://localhost:8080/exampleGet/request2/Jeinsson
   * los parametros se agregan en el GetMapping con un {var} y se pasan por medio de la anotación @PathVariable("nm");
   * donde nm es el nombre del parametro que enviaríamos por la url
   * @param name
   * @return
   */
  @GetMapping("/request2/{nm}")
  public ModelAndView request2(@PathVariable(value = "nm") String name){
    ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
    //paso del parametro mediante el mav "nm_in_model": nombre usado en la pág html
    mav.addObject("nm_in_model", name);
    return mav;
  }
}
