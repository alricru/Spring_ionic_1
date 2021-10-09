package com.videoGames.alejandro.entity.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videogames")
public class videoGames implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String genre;
	
	private int year;
	
	private String platform;
	
	private int pegi;
	
	public videoGames(long id, String name, String genre, int year, String platform, int pegi) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.year = year;
		this.platform = platform;
		this.pegi = pegi;
	}
	
	public videoGames() {
		
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

}
