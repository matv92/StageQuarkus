package com.farnetworks.quarkus.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farnetworks.quarkus.model.Person;
import com.farnetworks.quarkus.repository.PersonRepository;

@RestController
@RequestMapping("/quarkus")
public class RestService {

    @Autowired
	private PersonRepository repo;

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello Quarkus";
    }

	@PostMapping(path = "/person")
	public Person createPerson(@Valid @RequestBody Person personRequest) throws Exception {
		
		return repo.save(personRequest);
	}
	
	@PutMapping(path = "/person/{id}")
	public Person updatePerson(@RequestBody Person newPerson, @PathVariable Long id) throws Exception {
		
		return repo.findById(id).map(person -> {
			person.setAddress(newPerson.getAddress());
			person.setEmail(newPerson.getEmail());
			person.setFiscalCode(newPerson.getFiscalCode());
			person.setGender(newPerson.getGender());
			person.setName(newPerson.getName());
			person.setSurname(newPerson.getSurname());
            return repo.save(person);
        }).orElseGet(() -> {
        	newPerson.setId(id);
            return repo.save(newPerson);
        });	}

	@DeleteMapping(path = "/person/{id}")
	public void deletePersonById(@PathVariable Long id) throws Exception {
		
		repo.deleteById(id);
	}

	@GetMapping("/person/{id}")
	public Person getPersonById(@PathVariable Long id) {
		
		return repo.findById(id).get();
	}

	@GetMapping(path = "/persons")
	public List<Person> getAllPerson() throws Exception {

		return repo.findAll();
	}
}
