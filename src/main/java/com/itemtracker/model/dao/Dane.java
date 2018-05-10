package com.itemtracker.model.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Dane",uniqueConstraints = {@UniqueConstraint(columnNames= {"kopalnia_id","sortyment_id"})})
public class Dane {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 11)
	int id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kopalnia_id",referencedColumnName="id")
	Kopalnia kopalnia_id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sortyment_id",referencedColumnName="id")
	Sortyment sortyment_id;
	
	@Column
	String klasa;
	@Column
	double wymiar_dolny;
	@Column
	double wymiar_gorny;
	@Column
	double popiol;
	@Column
	double siarka;
	@Column
	double spiekalnosc_od;
	@Column
	double spiekalnosc_do;
	
	
	public Dane() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kopalnia getKopalnia_id() {
		return kopalnia_id;
	}

	public void setKopalnia_id(Kopalnia kopalnia_id) {
		this.kopalnia_id = kopalnia_id;
	}

	public Sortyment getSortyment_id() {
		return sortyment_id;
	}

	public void setSortyment_id(Sortyment sortyment_id) {
		this.sortyment_id = sortyment_id;
	}

	public String getKlasa() {
		return klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}

	public double getWymiar_dolny() {
		return wymiar_dolny;
	}

	public void setWymiar_dolny(double wymiar_dolny) {
		this.wymiar_dolny = wymiar_dolny;
	}

	public double getWymiar_gorny() {
		return wymiar_gorny;
	}

	public void setWymiar_gorny(double wymiar_gorny) {
		this.wymiar_gorny = wymiar_gorny;
	}

	public double getPopiol() {
		return popiol;
	}

	public void setPopiol(double popiol) {
		this.popiol = popiol;
	}

	public double getSiarka() {
		return siarka;
	}

	public void setSiarka(double siarka) {
		this.siarka = siarka;
	}

	public double getSpiekalnosc_od() {
		return spiekalnosc_od;
	}

	public void setSpiekalnosc_od(double spiekalnosc_od) {
		this.spiekalnosc_od = spiekalnosc_od;
	}

	public double getSpiekalnosc_do() {
		return spiekalnosc_do;
	}

	public void setSpiekalnosc_do(double spiekalnosc_do) {
		this.spiekalnosc_do = spiekalnosc_do;
	}

	
	
	
	
}
