package com.example.demo.product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;


	@GetMapping("/products")
	public List<Product> retrieveAllStudents() {
		return productRepository.findAll();
	}

	@GetMapping("/productsbyid/{id}")
	public Product retrieveProduct(@PathVariable long id) throws Exception {
		Optional<Product> student = productRepository.findById(id);

		if (!student.isPresent())
			throw new Exception("id-" + id);

		return student.get();
	}

	@RequestMapping("/prize/range/{min}/{max}")
	public List<Product> retrieveProduct(@PathVariable int min , @PathVariable int max ) throws Exception {
	
		Iterable<Product> product=productRepository.findAll();
		return ((Collection<Product>) product).stream()
				.filter(p -> (p.getCost()>min && p.getCost()<max))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/name/{name}")
	public List<Product> retrieveProductname(@PathVariable String name) throws Exception {
	

		return  productRepository.findByName(name);
	}
	
	@GetMapping("/type/{type}")
	public List<Product> retrieveProducttype(@PathVariable String type) throws Exception {
	

		return  productRepository.findByType(type);
	}
	@GetMapping("/subtype/{subtype}")
	public List<Product> retrieveProductsubtype(@PathVariable String subtype) throws Exception {
	

		return  productRepository.findBySubtype(subtype);
	}

	
	@GetMapping("/brand/{brand}")
	public List<Product> retrieveProductBrand(@PathVariable String brand) throws Exception {
	

		return  productRepository.findByBrand(brand);
	}


	@RequestMapping("/date/range/{prod1}/{prod2}")
	public List<Product> retrieveProduct(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd")
	 
 Date prod1 , @DateTimeFormat(pattern="yyyy-MM-dd")@PathVariable Date prod2 ) throws Exception {

		Iterable<Product> product = productRepository.findAll();
		return ((Collection<Product>) product).stream()
				.filter(p -> (p.getDate().compareTo(prod1)>0 && p.getDate().compareTo(prod2)<0))
				.collect(Collectors.toList());
	}
	
	
	@DeleteMapping("/deletproducts/{id}")
	public void deleteStudent(@PathVariable long id) {
		productRepository.deleteById(id);
	}

	@PostMapping("/addproducts")
	public ResponseEntity<Object> createStudent(@RequestBody Product student) {
	
		Product savedStudent = productRepository.save(student);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	
	

	@PostMapping("/loadproducts")
	public void load(@RequestBody Product student) throws IOException {


		 String line;
		FileInputStream fr=new FileInputStream("C:/Users/vijetha.g/Desktop/sample.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));		
         
	           while ((line = br.readLine()) != null) {
	        	   String s[]=new String[10];
	
		    s= line.split(",");
		    student.getId();
		    student.setName(s[0]);
			student.setType(s[1]);
			student.setSubtype(s[2]);
			student.setBrand(s[3]);
			student.setCost(Integer.parseInt(s[4]));
				productRepository.save(student);
	//System.out.println(s[0]);
	}
br.close();
}

	@PutMapping("/updateproducts/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Product student, @PathVariable long id) {

		Optional<Product> studentOptional = productRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		productRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}