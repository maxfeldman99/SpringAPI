package com.max.demo.api;

import com.max.demo.model.Person;
import com.max.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


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

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}") // taking the id and turning into UUID
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);

    }
    @DeleteMapping(path = "{id}") // passing the id down to the service
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Person personToUpdate){ // valid will check the restriction inside person model
        personService.updatePerson(id,personToUpdate);
    }
}
