package com.itemtracker.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Kopalnia",uniqueConstraints = {@UniqueConstraint(columnNames="name")})
public class Kopalnia {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 11)
	int id;
	
	@Column(name ="name",length= 50,unique=true)
	String name;

	public Kopalnia() {}
	
	public Kopalnia(String name) {
		this.name=name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
