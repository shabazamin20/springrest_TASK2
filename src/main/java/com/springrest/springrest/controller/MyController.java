package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Person;
import com.springrest.springrest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MyController {
    @Autowired
    PersonService service ;

    @GetMapping("/home")
    public String getString (){
        return "App Is Running";
    }
    @GetMapping("/personlist")
    public List<Person> getpersonList(){

        return this.service.getPersons();
    }

    @GetMapping("/nestedJsonResponse")
    public List<Map<String, Object>> getNestedJsonResponse() {
        // Fetch the list of persons from the database (replace this with your actual data retrieval code)
        List<Person> personList = this.service.getPersons();

        // Build the nested JSON response
        return buildNestedJson(personList);
    }
    private static List<Map<String, Object>> buildNestedJson(List<Person> personList) {
        Map<Long, Map<String, Object>> personMap = new HashMap<>();
        List<Map<String, Object>> topLevelClasses = new ArrayList<>();


        for (Person person : personList) {
            Map<String, Object> personData = new HashMap<>();
            personData.put("Name", person.getName());
            personMap.put(person.getId(), personData);

            if (person.getParentId() == 0) {
                topLevelClasses.add(personData);
            }
        }


        for (Person person : personList) {
            if (person.getParentId() != 0) {
                Map<String, Object> currentPerson = personMap.get(person.getId());
                Map<String, Object> parent = personMap.get(person.getParentId());

                if (!parent.containsKey("Sub Classes")) {
                    parent.put("Sub Classes", new ArrayList<>());
                }

                List<Map<String, Object>> subClasses = (List<Map<String, Object>>) parent.get("Sub Classes");
                subClasses.add(currentPerson);
            }
        }

        
        for (Map<String, Object> topLevelClass : topLevelClasses) {
            sortSubClasses(topLevelClass);
        }

        return topLevelClasses;
    }

    private static void sortSubClasses(Map<String, Object> parent) {
        if (parent.containsKey("Sub Classes")) {
            List<Map<String, Object>> subClasses = (List<Map<String, Object>>) parent.get("Sub Classes");
            for (Map<String, Object> subClass : subClasses) {
                sortSubClasses(subClass);
            }
            subClasses.sort(Comparator.comparing(o -> (String) o.get("Name")));
        }
    }




}
