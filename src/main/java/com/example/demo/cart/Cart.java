package com.example.demo.cart;


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

@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
		private Integer cartid;

	 @Column(name = "cname")
	    private String cname;
	 @Column(name = "ccost")
	    private Integer ccost;
	
	 @Column(name = "c_id")
	
	    private Integer c_id;
		

	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}



	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCcost() {
		return ccost;
	}

	public void setCcost(Integer ccost) {
		this.ccost = ccost;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}


	


	
		
		 
}
