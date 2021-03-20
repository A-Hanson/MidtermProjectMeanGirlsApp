package com.skilldistillery.jpameangirls.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookCommentVote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean vote;

// TODO: mapping
//		@Column(name="burn_book_comment_id")
//		private Integer burnBookCommentId;

// TODO: mapping
//		@Column(name="student_id")
//		private Integer studentId;

	// Methods:
	// TODO: getters and setters for burnBookCommentId and studentId
	// TODO: generate toString() when all fields complete
	public BookCommentVote() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (vote ? 1231 : 1237);
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
		BookCommentVote other = (BookCommentVote) obj;
		if (id != other.id)
			return false;
		if (vote != other.vote)
			return false;
		return true;
	}



}