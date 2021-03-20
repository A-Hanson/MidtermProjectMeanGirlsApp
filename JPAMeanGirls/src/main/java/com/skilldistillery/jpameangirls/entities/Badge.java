package com.skilldistillery.jpameangirls.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Badge {

// TODO
// private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="image_url")
	private String imageUrl;
	
}
