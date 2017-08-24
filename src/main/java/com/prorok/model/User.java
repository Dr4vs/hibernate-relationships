package com.prorok.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {


	private static final long serialVersionUID = -641044744609882466L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;
	@Column(nullable=false,unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false,unique=true)
	private String email;
	@OneToOne
	private UserDetails userDetails;

	public User() {
	}

	
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}



	public User(String username, String password, String email, UserDetails userDetails) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.userDetails = userDetails;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", userDetails=" + userDetails + "]";
	}

}
