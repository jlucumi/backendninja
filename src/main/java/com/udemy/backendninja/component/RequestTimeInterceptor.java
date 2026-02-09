package com.udemy.backendninja.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Clase encargada de calcular el tiempo de las peticiones http, hará que por cada
 * petición que nos hagan entre a la clase sobreescribiendo los metodos de la clase handler
 *
 * Para que esta sección funcione, debemos registrar el interceptor en la clase de configuración
 *
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor implements HandlerInterceptor
{
  private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

  /**
   * Se ejecuta antes de entrar en el metodo del controlador
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
  {
    //Atributo para guardarlo al volver
    request.setAttribute("startTime",System.currentTimeMillis());
    return true;
  }

  /**
   * Se ejecuta antes de mostrar la pantalla en el navegador
   * @param request
   * @param response
   * @param handler
   * @param ex
   * @throws Exception
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception
  {
    long startTime = (long) request.getAttribute("startTime");
    LOG.info("--REQUEST URL: '" +request.getRequestURL()+ "' -- TOTAL TIME: '"+ (System.currentTimeMillis()-startTime) +"'ms");
  }
}
