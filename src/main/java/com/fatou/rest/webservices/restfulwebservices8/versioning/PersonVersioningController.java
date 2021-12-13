package com.fatou.rest.webservices.restfulwebservices8.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public Person1 personv1() { 
		return new Person1("Bob Charlie");
	}

	
	@GetMapping("v2/person")
	public Person2 personv2() { 
		return new Person2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(value = "/person/param", params = "version=1")
	public Person1 paramv1() { 
		return new Person1("Bob Charlie");
	}

	
	@GetMapping(value = "/person/param", params = "version=2")
	public Person2 paramv2() { 
		return new Person2(new Name("Bob" ,"Charlie"));
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public Person1 headerv1() { 
		return new Person1 ("Bob Charlie");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public Person2 headerv2() { 
		return new Person2 (new Name("Bob"," Charlie"));
	}

	
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public Person1 producesv1() { 
		return new Person1 ("Bob Charlie");
	}
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public Person2 producesv2() { 
		return new Person2 (new Name("Bob"," Charlie"));
	}
}








