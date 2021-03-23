package com.skilldistillery.jpameangirls.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String content;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "last_edited")
	private LocalDateTime lastEdited;

	private Boolean enabled;

	private Boolean flagged;

	@ManyToOne
	@JoinColumn(name = "clique_id")
	private Clique clique;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@OneToMany(mappedBy="comment")
	private List<CommentVote> commentVotes;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "replying_to")
	private Comment replyingTo;
	
	@OneToMany(mappedBy="replyingTo")
	private List<Comment> replies;

//	Constructor
	public Comment() {
	}

//	Methods
	
	/*
	 *  Note: I don't think there will ever be a case where 
	 *  	a comment R would be a reply to comment A, 
	 *  	and then later switch to being a reply of Comment B. 
	 *  	I didn't write for this scenario. 
	 */
	public void addReply(Comment comment) {
		
		if(replies == null) {
			replies = new ArrayList<>();
		}
		
		if(!replies.contains(comment)) {
			replies.add(comment);
			comment.setReplyingTo(this);
		}
	}
	
	public void removeReply(Comment reply) {
		
		if(replies == null) {
			replies = new ArrayList<>();
		}
		
		if(replies.contains(reply)) {
			replies.remove(reply);
			reply.replyingTo = null;
		}
	}
	
	public Comment getReplyingTo() {
		return replyingTo;
	}

	public void setReplyingTo(Comment replyingTo) {
		this.replyingTo = replyingTo;
	}

	public List<Comment> getReplies() {
		return replies;
	}

	public void setReplies(List<Comment> replies) {
		this.replies = replies;
	}

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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(LocalDateTime lastEdited) {
		this.lastEdited = lastEdited;
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

	public Clique getClique() {
		return clique;
	}

	public void setClique(Clique clique) {
		this.clique = clique;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<CommentVote> getCommentVotes() {
		return commentVotes;
	}

	public void setCommentVotes(List<CommentVote> commentVotes) {
		this.commentVotes = commentVotes;
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
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", createdDate=" + createdDate + ", lastEdited="
				+ lastEdited + ", enabled=" + enabled + ", flagged=" + flagged + "]";
	}

}
