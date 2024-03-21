package com.spring.controller;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entities.onetomany.MobileEntity;
import com.spring.entities.onetomany.Person;
import com.spring.repositories.PersonRepository;

import javax.annotation.PostConstruct;

@Controller
//@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository personRepositories;

	@PostConstruct
	public void addData(){
		personRepositories.save(new Person(123, "samm", Arrays.asList(new MobileEntity(1, "5918943774"))));
//		personRepositories.save(new Person(123, "samm", Arrays.asList(new MobileEntity(2, "985698569"))));
//		personRepositories.save(new Person(123, "samm", Arrays.asList(new MobileEntity(3, "957845896"))));

		personRepositories.save(new Person(154, "mike", Arrays.asList(new MobileEntity(4, "879654321"))));
//		personRepositories.save(new Person(154, "mike", Arrays.asList(new MobileEntity(5, "952012365"))));
//		personRepositories.save(new Person(154, "mike", Arrays.asList(new MobileEntity(6, "859869325"))));

	}
	
	@GetMapping("/example")
	public ResponseEntity<?> example(){
		return ResponseEntity.ok(new Person());
	}

	@PostMapping("/create")
	public ResponseEntity<?> createPerson(@RequestBody(required = true) Person person) {
		personRepositories.save(person);
		return ResponseEntity.ok(person);
	}
	
	
	@PostMapping("{id}/add")
	public ResponseEntity<?> addMobileEntity(@PathVariable(name="id") int id, @RequestBody(required = true) MobileEntity MobileEntity) {
		Person person = personRepositories.findById(id).get();
		person.add(MobileEntity);
		personRepositories.save(person);
		return ResponseEntity.ok(person);
	}

	@PostMapping("/delete")
	public ResponseEntity<?> deletePerson(@RequestParam(required = true, name = "personId") int id) {
		Optional<Person> person = personRepositories.findById(id);
		if (person.isPresent()) {
			personRepositories.delete(person.get());
			return ResponseEntity.ok(person.get());
		}
		return ResponseEntity.ok(new Person());
	}

	@GetMapping
	public ResponseEntity<?> getPersonWithMobileEntity(@RequestParam(required = true, name = "id")int id){
		Optional<Person> person = personRepositories.findById(id);
		return person.<ResponseEntity<?>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(new Person()));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllPerson(@RequestParam(value = "offset", required = false)Integer offset, @RequestParam(value = "pagesize", required = false)Integer pagesize){
		if(Objects.nonNull(pagesize) && Objects.nonNull(offset))
			return ResponseEntity.ok(personRepositories.findAll(PageRequest.of(offset, pagesize)).stream().collect(Collectors.toList()));

		return ResponseEntity.ok(personRepositories.findAll(Sort.by(Sort.Direction.ASC, "name")));
	}


}
