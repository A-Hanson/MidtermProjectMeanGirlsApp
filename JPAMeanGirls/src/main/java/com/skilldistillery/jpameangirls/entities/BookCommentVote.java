package com.skilldistillery.jpameangirls.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_comment_vote")
public class BookCommentVote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Boolean getVote() {
		return vote;
	}

	public void setVote(Boolean vote) {
		this.vote = vote;
	}

	@Column(columnDefinition = "TINYINT")
	private Boolean vote;

	@ManyToOne
	@JoinColumn(name = "burn_book_comment_id")
	private BurnBookComment burnBookCommentId;

// TODO: mapping
//		private Integer studentId;

	public BookCommentVote() {
	}

	public BurnBookComment getBurnBookCommentId() {
		return burnBookCommentId;
	}

	public void setBurnBookCommentId(BurnBookComment burnBookCommentId) {
		this.burnBookCommentId = burnBookCommentId;
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