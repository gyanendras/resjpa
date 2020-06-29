package com.mysystems.restJpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysystems.restJpa.domain.Person;
import com.mysystems.restJpa.repo.PersonRepository;

@SpringBootTest
class PersonRepoTest {
	@Autowired
	PersonRepository pr;

	@Test
	void createPersonRepo() {
		Person person = new Person();
		person.setFirstName("PFName");
		person.setLastName("PLName");
		 pr.save(person);
	}

	
	@Test
	void getPersonByLastName() {
			List<Person> pList= pr.findByLastName("PLName");
			assertEquals(1,pList.size());
	}
}
