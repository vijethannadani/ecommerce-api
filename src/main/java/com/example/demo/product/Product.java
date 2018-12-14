package com.example.demo.product;
import java.util.Date;

//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity

@Table(name = "seller")
public class Product {
	@Id
@GeneratedValue
	private long id;
	 @Column(name = "name")
	private String name;
	 @Column(name = "type")
		private String type;
	 @Column(name = "subtype")
		private String subtype;
	 @Column(name = "brand")
	private String brand;
	 @Column(name = "cost")
	private int cost;

	 @Column(name = "date")
	private Date date;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}

@JsonSerialize(using=JsonDateSerializer.class)
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	

	
		
}