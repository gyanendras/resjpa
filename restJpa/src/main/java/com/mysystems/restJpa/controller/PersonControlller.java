package com.mysystems.restJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysystems.restJpa.domain.Person;
import com.mysystems.restJpa.repo.PersonRepository;

@RestController
public class PersonControlller {
	@Autowired
	PersonRepository pr;
	
	@RequestMapping(method=RequestMethod.GET,value="/persons/{lname}")
	public List<Person> getPersonsByLastName(@PathVariable String lname) {
		List list = pr.findByLastName(lname);
		return list;
	}
	
	
	@PostMapping(value="/persons",consumes = "application/json")
	public  Person addPerson(@RequestBody Person person)  {
		return pr.save(person);
	}

}
