package com.example.demo.customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.product.Product;



@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;


	@GetMapping("/customer")
	public List<Customer> retrieveAllStudents() {
		return customerRepository.findAll();
	}
	@PostMapping("/addcustomer")
	public ResponseEntity<Object> createStudent(@RequestBody Customer student) {
		Customer savedStudent = customerRepository.save(student);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getC_id()).toUri();

		return ResponseEntity.created(location).build();

	}
	@GetMapping("/customerbyid/{c_id}")
	public Customer retrievecustomer(@PathVariable Integer c_id) throws Exception {
		Optional<Customer> student = customerRepository.findById(c_id);

		if (!student.isPresent())
			throw new Exception("c_id-" + c_id);

		return student.get();
	}

}
