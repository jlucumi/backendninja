package com.udemy.backendninja.service;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExampleService
{
  public abstract List<Person> getListPeople();
}
