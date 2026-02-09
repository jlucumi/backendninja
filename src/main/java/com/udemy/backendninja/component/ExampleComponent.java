package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Para que spring lo guarde en su memoría al iniciar
 */
@Component("exampleComponent")
public class ExampleComponent
{
  private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
  /**
   * permitira saber si entró o no cuando se llame desde un controller
   */
  public void sayHello(){
    LOG.info("Hello from exampleComponent");
  }

}
