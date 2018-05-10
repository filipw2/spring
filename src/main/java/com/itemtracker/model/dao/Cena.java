package com.itemtracker.model.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="dane_id")})
public class Cena {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 11)
	int id;
	
	@Column
	double cena_bez_akcyzy;
	@Column
	double cena_z_akcyza;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dane_id",referencedColumnName="id")
	Dane dane_id;
	@Column
	@Temporal(TemporalType.DATE)
	Date data;
	
	public Cena() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCena_bez_akcyzy() {
		return cena_bez_akcyzy;
	}
	public void setCena_bez_akcyzy(double cena_bez_akcyzy) {
		this.cena_bez_akcyzy = cena_bez_akcyzy;
	}
	public double getCena_z_akcyza() {
		return cena_z_akcyza;
	}
	public void setCena_z_akcyza(double cena_z_akcyza) {
		this.cena_z_akcyza = cena_z_akcyza;
	}
	public Dane getDane_id() {
		return dane_id;
	}
	public void setDane_id(Dane dane_id) {
		this.dane_id = dane_id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
