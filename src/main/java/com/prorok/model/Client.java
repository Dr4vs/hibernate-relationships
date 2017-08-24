package com.prorok.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7258190105462220326L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long id;
	@Column(name="firstname",nullable=false)
	private String firstName;
	@Column(name="lastname",nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String adres;
	@OneToMany(mappedBy="client")
	private List<Order> orders;

	public Client() {
	}

	public Client(String firstName, String lastName, String adres) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adres = adres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adres=" + adres
				+ ", orders=" + orders + "]";
	}

}
