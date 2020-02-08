package com.max.demo.api;

import com.max.demo.model.Person;
import com.max.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private  final PersonService personService;

    @Autowired // injects into the constructor below
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){ // requestBody to insert rest body inside
        personService.addPerson(person);

    }
}
