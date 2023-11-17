package com.springrest.springrest.service;

import com.springrest.springrest.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface persdao extends JpaRepository<Person,Long> {
}
