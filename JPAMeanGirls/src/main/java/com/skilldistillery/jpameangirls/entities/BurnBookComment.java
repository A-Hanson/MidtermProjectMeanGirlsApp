package com.skilldistillery.jpameangirls.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="burn_book_comment")
public class BurnBookComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String content;
	
	@Column(columnDefinition = "TINYINT")
	private Boolean enabled;
	
	private Boolean flagged;
	
	@Column(name="author_id")
	private int authorId;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="student_id")
	private int studentId;	
	
	private Boolean vote;
	
//	Constructor
	public BurnBookComment() {}

//	Methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(Boolean flagged) {
		this.flagged = flagged;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Boolean getVote() {
		return vote;
	}

	public void setVote(Boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "BurnBookComment [id=" + id + ", content=" + content + ", enabled=" + enabled + ", flagged=" + flagged
				+ ", authorId=" + authorId + ", createdDate=" + createdDate + ", studentId=" + studentId + ", vote="
				+ vote + "]";
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
		BurnBookComment other = (BurnBookComment) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
