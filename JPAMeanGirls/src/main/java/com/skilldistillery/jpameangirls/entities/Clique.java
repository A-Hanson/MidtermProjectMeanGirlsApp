package com.skilldistillery.jpameangirls.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	@ManyToMany
	@JoinTable(name="student_clique",
	    joinColumns=@JoinColumn(name="student_id"),
	    inverseJoinColumns=@JoinColumn(name="clique_id")
	  )
	private List<Student> students;
	
	@OneToMany(mappedBy = "clique")
	private List<Comment> comments;
	
	private Boolean enabled;
	
//	Constructor
	public Clique() {}

//	Methods
	
	public void addStudent(Student student) {
		if (students == null) {
			students = new ArrayList<>();
		}

		if (!students.contains(student)) {
			students.add(student);
			student.addClique(this);
		}
	}

	public void removeStudent(Student student) {
		if (students != null && students.contains(student)) {
			student.removeClique(this);
			students.remove(student);
		}
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
	

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
