package com.example.demo.product;


import java.util.List;

//StudentRepository

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{


	public List<Product> findByName(String name);

		public List<Product> findByType(String type);

		public List<Product> findBySubtype(String subtype);
		 

		public List<Product> findByCost(int name);

		public List<Product> findByBrand(String name);
	 


	

	



	 
	
}
