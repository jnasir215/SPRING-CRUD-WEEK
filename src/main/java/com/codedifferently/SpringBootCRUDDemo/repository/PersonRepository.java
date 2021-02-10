package com.codedifferently.SpringBootCRUDDemo.repository;

import com.codedifferently.SpringBootCRUDDemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
