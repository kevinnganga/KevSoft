package com.kevo.co.ke.KevSoft.USERS;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import com.kevo.co.ke.KevSoft.ORDERS.Orders;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",nullable = false,unique = true,updatable = false)
	private Long id;
	
	@NotEmpty(message = "Username is Mandatory field. Please provide a username")
	@Column(name = "USER_NAME",length = 50,nullable = false,unique = true)
	private String username;
	
	@Size(min = 2 ,message = "FirstName should have atleast 2 characters")
	@Column(name = "FIRST_NAME",length = 50,nullable = false)
	private String firstname;
	
	@Column(name = "LAST_NAME",length = 50,nullable = false)
	private String lastname;
	
	@Column(name = "EMAIL_ADDRESS",length = 50,nullable = false,unique = true)
	private String email;
	
	@Column(name = "ROLE",length = 50,nullable = false)
	private String role;
	
	@Column(name = "SSN",length = 50,nullable = false,unique = true)
	private String ssn;  //SOCIAL SECURITY NUMBER
	
	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();
    
  
    @OneToMany(mappedBy = "user")
	private List<Orders>orders;
    
    


	//No Arguments Constructor
	public User() {
		
	}

	
	//Fields Constructor
	public User(Long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}
	
	
	



	public User(Long id, @NotEmpty(message = "Username is Mandatory field. Please provide a username") String username,
			@Size(min = 2, message = "FirstName should have atleast 2 characters") String firstname, String lastname,
			String email, String role, String ssn, @NotNull Date postedAt, @NotNull Date lastUpdatedAt,
			List<Orders> orders) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.postedAt = postedAt;
		this.lastUpdatedAt = lastUpdatedAt;
		this.orders = orders;
	}


	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	//Getters And Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	
	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	//To String
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
	
	
	 
	
	
	
	
	

}