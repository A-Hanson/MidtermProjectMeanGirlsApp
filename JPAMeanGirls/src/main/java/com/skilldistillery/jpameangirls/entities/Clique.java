package com.skilldistillery.jpameangirls.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="min_fetch_level")
	private Integer minimumFetchLevel;

	@Column(name="image_url")
	private String imageUrl;
	
	private String description;
	
//	Constructor
	public Clique() {}

//	Methods
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

	public Integer getMinimumFetchLevel() {
		return minimumFetchLevel;
	}

	public void setMinimumFetchLevel(Integer minimumFetchLevel) {
		this.minimumFetchLevel = minimumFetchLevel;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Clique [id=" + id + ", name=" + name + ", minimumFetchLevel=" + minimumFetchLevel + ", imageUrl="
				+ imageUrl + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clique other = (Clique) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
