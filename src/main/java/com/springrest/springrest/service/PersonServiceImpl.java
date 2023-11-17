package com.springrest.springrest.service;

import com.springrest.springrest.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{

    public PersonServiceImpl (){

    }
    @Autowired
    persdao dao;
    @Override
    public List<Person> getPersons() {


//        List personList = new ArrayList<>();
//        personList.add(new Person(1L, 0L, "Warrior", "red"));
//        personList.add(new Person(2L, 0L, "Wizard", "green"));
//        personList.add(new Person(3L, 0L, "Priest", "white"));
//        personList.add(new Person(4L, 0L, "Rogue", "yellow"));
//        personList.add(new Person(5L, 1L, "Fighter", "blue"));
//        personList.add(new Person(6L, 1L, "Paladin", "lightblue"));
//        personList.add(new Person(7L, 1L, "Ranger", "lightgreen"));
//        personList.add(new Person(8L, 2L, "Mage", "grey"));
//        personList.add(new Person(9L, 2L, "Specialist wizard", "lightgrey"));
//        personList.add(new Person(10L, 3L, "Cleric", "red"));
//        personList.add(new Person(11L, 3L, "Druid", "green"));
//        personList.add(new Person(12L, 3L, "Priest of specific mythos", "white"));
//        personList.add(new Person(13L, 4L, "Thief", "yellow"));
//        personList.add(new Person(14L, 4L, "Bard", "blue"));
//        personList.add(new Person(15L, 13L, "Assassin", "lightblue"));
//        return personList;

        return dao.findAll();
    }
}
