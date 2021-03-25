package com.skilldistillery.jpameangirls.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
	private LocalDate birthdayDate;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private Boolean enabled;
	
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="studentId")
	private List<BurnBookComment> burnBookCommentsAboutMe;
	
	@OneToMany(mappedBy="student")
	private List<BookCommentVote> burnCommentVotes;
	
	@Transient
	private int totalFetch;
	
	
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
	public void setUser(User user) {
		this.user = user;
	}


	public List<Clique> getCliques() {
		return cliques;
	}

	public void setCliques(List<Clique> cliques) {
		this.cliques = cliques;
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

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	// other methods
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public void addBadge(Badge badge) {
		if (badges == null) {
			badges = new ArrayList<Badge>();
		}
		if (! badges.contains(badge)) {
			badges.add(badge);
			badge.addStudent(this);
		}
	}
	
	public void removeBadge(Badge badge) {
		if (badges != null & badges.contains(badge)) {
			badges.remove(badge);
			badge.removeStudent(this);
		}
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

	
	
	public int getTotalFetch() {
		return totalFetch;
	}

	public void setTotalFetch(int totalFetch) {
		this.totalFetch = totalFetch;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
