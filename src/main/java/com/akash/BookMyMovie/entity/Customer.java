package com.akash.BookMyMovie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="customer_details")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@NotEmpty
	private String user_name;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String confirm_password;
	
	private String customer_name;
	
	public Customer() {
	}
	
	public Customer(String user_name, String password, String confirm_password, String customer_name) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.confirm_password = confirm_password;
		this.customer_name = customer_name;
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	@Override
	public String toString() {
		return "Customer [user_name=" + user_name + ", password=" + password + ", confirm_password="
				+ confirm_password + ", customer_name=" + customer_name + "]";
	}


}
