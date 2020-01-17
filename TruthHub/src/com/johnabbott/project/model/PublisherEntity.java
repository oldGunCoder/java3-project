package com.johnabbott.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "publisher")
public class PublisherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;
	
	@Column(name = "country")
	private String country;
	
//	@Column(name = "footage_id")
//	private String footage_id;

//	@ManyToOne
//	@JoinColumn(name = "footage_id")
//	private FootageEntity footage;
	
	
//	public FootageEntity getFootage() {
//		return footage;
//	}
//
//	public void setFootage(FootageEntity footage) {
//		this.footage = footage;
//	}

	public PublisherEntity(int i, String string, String string2) {

	}
	
	public PublisherEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Object getPublisher() {
		// TODO Auto-generated method stub
		return null;
	}


}
