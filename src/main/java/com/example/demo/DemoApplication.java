package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController	
public class DemoApplication {
	List<Person> people = new ArrayList<Person>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return String.format("Hola mundo");
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name",defaultValue = "Mundo") String name){
		return String.format("Hola %s!!", name);
	}
	@GetMapping("/people")
	public List<Person> person(@RequestParam(value = "name",defaultValue = "robert") String name){
		if (people.isEmpty()) {
			people.add(new Person(name,20));
		}
		return people;
	}
	@PostMapping("/people")
	public List<Person> addperson(@RequestBody Person person){
		people.add(person);
		return people;
	}

}

class Person {
	public String name;
	public int age;
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
}
