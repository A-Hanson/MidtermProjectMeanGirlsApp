package com.skilldistillery.jpameangirls.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="grade_level")
	private Integer gradeLevel;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="birthday_date")
	private LocalDateTime birthdayDate;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@ManyToMany(mappedBy = "students")
	private List<Badge> badges;
	
	@ManyToMany(mappedBy="students")
	private List<Clique> cliques;
	
	@OneToMany(mappedBy="student")
	private List<Comment> comments;
	
	@OneToMany(mappedBy="student")
	private List<CommentVote> commentVotes;
	
	@OneToMany(mappedBy="authorId")
	private List<BurnBookComment> burnBookCommentsAuthored;
	
	@OneToMany(mappedBy="studentId")
	private List<BurnBookComment> burnBookCommentsAboutMe;
	
	@OneToMany(mappedBy="student")
	private List<BookCommentVote> burnCommentVotes;
	
	
	// constructors
	
	public Student() {}

	// getters and setters
	
	
	


	public List<BurnBookComment> getBurnBookCommentsAuthored() {
		return burnBookCommentsAuthored;
	}

	public void setBurnBookCommentsAuthored(List<BurnBookComment> burnBookCommentsAuthored) {
		this.burnBookCommentsAuthored = burnBookCommentsAuthored;
	}

	public List<BurnBookComment> getBurnBookCommentsAboutMe() {
		return burnBookCommentsAboutMe;
	}

	public void setBurnBookCommentsAboutMe(List<BurnBookComment> burnBookCommentsAboutMe) {
		this.burnBookCommentsAboutMe = burnBookCommentsAboutMe;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComment(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		if (!comments.contains(comment)) {
			comments.add(comment);
			if (comment.getStudent() != null) {
				comment.getStudent().getComments().remove(comment);
			}
			comment.setStudent(this);
		}
	}
	
	public void removeComment(Comment comment) {
		comment.setStudent(null);
		if (comments != null) {
			comments.remove(comment);
		}
	}

	public User getUser() {
		return user;
	}

	public List<Clique> getCliques() {
		return cliques;
	}

	public void setCliques(List<Clique> cliques) {
		this.cliques = cliques;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void addClique(Clique clique) {
		if (cliques == null) {
			cliques = new ArrayList<>();
		}
		if (! cliques.contains(clique)) {
			cliques.add(clique);
			clique.addStudent(this);
		}
	}
	
	public void removeClique(Clique clique) {
		if (cliques != null && cliques.contains(clique)) {
			cliques.remove(clique);
			clique.removeStudent(this);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(Integer gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDateTime birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	// other methods
	
	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public List<CommentVote> getCommentVotes() {
		return commentVotes;
	}

	public void setCommentVotes(List<CommentVote> commentVotes) {
		this.commentVotes = commentVotes;
	}
	

	public List<BookCommentVote> getBurnCommentVotes() {
		return burnCommentVotes;
	}

	public void setBurnCommentVotes(List<BookCommentVote> burnCommentVotes) {
		this.burnCommentVotes = burnCommentVotes;
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", gradeLevel=" + gradeLevel + ", createdDate=" + createdDate + ", birthdayDate=" + birthdayDate
				+ ", imageUrl=" + imageUrl + "]";
	} 
	
}
