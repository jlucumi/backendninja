package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * En el servicio va toda la lógica de la aplicación
 */
@Service("exampleServicesImpl")
public class ExampleServicesImpl implements ExampleService
{

  private static final Log LOG = LogFactory.getLog(ExampleServicesImpl.class);

  @Override
  public List<Person> getListPeople()
  {
    List<Person> people = new ArrayList<>();
    people.add(new Person("Jeinson", 37));
    people.add(new Person("Karol B", 28));
    people.add(new Person("Karol Jaz", 25));
    people.add(new Person("Oladis C", 63));
    LOG.info("HELLO FROM SERVICE");
    return people;
  }
}
