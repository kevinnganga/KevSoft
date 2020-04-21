package com.kevo.co.ke.KevSoft.ORDERS;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kevo.co.ke.KevSoft.USERS.User;

@Entity
public class Orders {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderdescription;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private User user;
	
	
	public Orders() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderdescription() {
		return orderdescription;
	}

	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
}
