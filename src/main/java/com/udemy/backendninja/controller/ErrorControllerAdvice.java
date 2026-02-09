package com.udemy.backendninja.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Anotación para que al presentarse un error spring venga a esta carpeta y muestre la info correspondiente
@ControllerAdvice
public class ErrorControllerAdvice
{
  //Teniendo en cuenta que html se encuentra dentro de una carpeta se le debe especificar dicha carpeta
  public static final String ERROR_500_VIEW = "error/500";

  /**
   * Método que controlará todos los errores que lance el sistema
   * Descomentarear para probar
   * @param model
   * @return A la pantalla de error 500
   */
  @ExceptionHandler(Exception.class)
  public String showInternalError(Model model)
  {
    return ERROR_500_VIEW;
  }

}
