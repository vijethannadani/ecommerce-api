package com.example.demo.cart;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
public class CartController {
	@Autowired
	private CartRepository cartRepository;


	@GetMapping("/cart")
	public List<Cart> retrieveAllStudents() {
		return cartRepository.findAll();
	}
	@PostMapping("/addcart")
	public ResponseEntity<Object> createStudent(@RequestBody Cart student) {
		Cart savedStudent = cartRepository.save(student);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getCartid()).toUri();

		return ResponseEntity.created(location).build();

	}

}
