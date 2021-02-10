package com.codedifferently.SpringBootCRUDDemo.service;

import com.codedifferently.SpringBootCRUDDemo.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    List<Person> getAllPersons();

    Person getPersonById(long personId);

    void deletePerson(long addressId);
}

