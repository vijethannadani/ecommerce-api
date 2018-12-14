package com.example.demo.customer;




import java.util.List;

import javax.persistence.CascadeType;

//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.example.demo.cart.Cart;



@Entity

@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
		private Integer c_id;
		 @Column(name = "name")
		private String c_name;
		
		 @Column(name = "phonenumber")
		private long c_ph;

		 @Column(name = "address")
		private String c_add;
		 
		  @OneToMany(cascade = CascadeType.ALL)
		    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
		    private List<Cart> cart;

		    public List<Cart> getProducts() {
		        return cart;
		    }

		    public void setProducts(List<Cart> usersLogs) {
		        this.cart = usersLogs;
		    }

		    public void Cart() {
		    }

	
		public Integer getC_id() {
				return c_id;
			}

			public void setC_id(Integer c_id) {
				this.c_id = c_id;
			}

		public String getC_name() {
			return c_name;
		}

		public void setC_name(String c_name) {
			this.c_name = c_name;
		}

		public long
		getC_ph() {
			return c_ph;
		}

		public void setC_ph(long c_ph) {
			this.c_ph = c_ph;
		}

		public String getC_add() {
			return c_add;
		}

		public void setC_add(String c_add) {
			this.c_add = c_add;
		}
		 
}
