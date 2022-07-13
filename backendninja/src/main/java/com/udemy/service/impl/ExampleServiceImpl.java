package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {

		List<Person> people = new ArrayList<>();
		people.add(new Person("Diego A", 10));
		people.add(new Person("Diego Ar", 20));
		people.add(new Person("Diego Arm", 30));
		people.add(new Person("Diego Arma", 40));
		people.add(new Person("Diego Arman", 50));
		people.add(new Person("Diego Armand", 60));
		
		LOG.info("Hello from service");
		return people;
	}

}
