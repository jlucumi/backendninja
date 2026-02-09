package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@Controller
@RequestMapping("/insert")
public class insertDatosController
{

  /**
   * Inyeccción de la capa de servicios en el controlador para acceder a la
   * información que llega desde negocio.
   * Instanciando la interfaz
   */
  @Autowired
  @Qualifier("exampleServicesImpl")
  private ExampleService exampleService;

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

  /**
   * Paso de un objeto a la gui de la forma 1
   * @param model
   * @return indica la ruta en la cual se mostrará la info
   */
  @GetMapping("/exampleObj1")
  public String exampleSendObj1(Model model){
    model.addAttribute("person", new Person("Karol", 29));
    return INSERT_VIEW;
  }

  @GetMapping("/exampleObj2")
  public ModelAndView exampleSendObj1(){
    //Se instancia un obj ModelAndView y se agregan los valores
    ModelAndView mav = new ModelAndView(INSERT_VIEW);
    mav.addObject("person", new Person("Jazzlovi", 25));
    return mav ;//Pantalla a la que se navegará
  }

  @GetMapping("/exampleGetPeople1")
  public String getPeopleObj1(Model model){
    model.addAttribute("people", exampleService.getListPeople());
    return INSERT_VIEW;
  }

  @GetMapping("/exampleGetPeople2")
  public ModelAndView getPeopleObj2(){
    //Se instancia un obj ModelAndView y se agregan los valores
    ModelAndView mav = new ModelAndView(INSERT_VIEW);
    mav.addObject("people", exampleService.getListPeople());
    return mav ;//Pantalla a la que se navegará
  }

}
