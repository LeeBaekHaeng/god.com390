package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	private final CustomerRepository repository;

	@Autowired
	public CustomerRestController(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Customer> findAll(Customer customer) {
		return repository.findAll(CustomerSpecs.spec2(customer));
	}

	@GetMapping("/search")
	public Map<String, Object> search(Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("search", "search");
		return map;
	}

	@GetMapping("/search2")
	public Map<String, Object> search2(Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("search2", "search2");
		return map;
	}

//	@GetMapping("/{id}/search/test1")
	@GetMapping("/search/test1")
	public Map<String, Object> searchTest1(Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("test1", "test1");
		return map;
	}

//	@GetMapping("/{id}/search/test2")
	@GetMapping("/search/test2")
	public Map<String, Object> searchTest2(Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("test2", "test2");
		return map;
	}

	@GetMapping("/{id}")
//	public Customer getOne(@PathVariable("id") Long id) {
	public Customer getOne(@PathVariable("id") String id) {
		return repository.getOne(Long.valueOf(id));
	}

	@GetMapping("/{id}/findByFirstName")
	public Map<String, Object> findByFirstName(@PathVariable("id") String id, Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("findByFirstName", "findByFirstName");
		return map;
	}

	@GetMapping("/{id}/findByLastName")
	public Map<String, Object> findByLastName(@PathVariable("id") String id, Customer customer) {
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		map.put("findByLastName", "findByLastName");
		return map;
	}

}
