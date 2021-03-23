package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpameangirls.entities.Comment;
import com.skilldistillery.jpameangirls.entities.CommentVote;
import com.skilldistillery.jpameangirls.entities.Student;

@Transactional
@Service
public class CommentVoteDAOImpl implements CommentVoteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public CommentVote create(CommentVote commentVote) {
		em.persist(commentVote);
		return commentVote;
	}

	@Override
	public CommentVote create(Student student, Comment comment, Boolean vote) {
		CommentVote cv = new CommentVote();
		cv.setStudent(student);
		cv.setComment(comment);
		cv.setVote(vote);
		em.persist(cv);
		return cv;
	}

	@Override
	public CommentVote update(int id, CommentVote commentVote) {
		CommentVote c = em.find(CommentVote.class, id);
		c.setVote(commentVote.getVote());
		return c;
	}

	@Override
	public boolean delete(int id) {
		CommentVote c = em.find(CommentVote.class, id);
		em.remove(c);
		return !em.contains(c);
	}

	@Override
	public int commentTotalScore(int commentId) {
		return (commentUpVoteTotal(commentId) - commentDownVoteTotal(commentId));
	}

	@Override
	public int commentUpVoteTotal(int commentId) {
		String query = "SELECT COUNT(cv) FROM CommentVote cv JOIN FETCH cv.comment WHERE (cv.comment.id=:cid AND cv.vote=TRUE";
		long count = em.createQuery(query, Long.class).setParameter("cid", commentId).getSingleResult();
		return (int) count;
	}

	@Override
	public int commentDownVoteTotal(int commentId) {
		String query = "SELECT COUNT(cv) FROM CommentVote cv JOIN FETCH cv.comment WHERE (cv.comment.id=:cid AND cv.vote=FALSE";
		long count = em.createQuery(query, Long.class).setParameter("cid", commentId).getSingleResult();
		return (int) count;
	}

	@Override
	public int studentTotalScore(int studentId) {
		return (studentUpVoteTotal(studentId) - studentDownVoteTotal(studentId));
	}

	@Override
	public int studentUpVoteTotal(int studentId) {
//		SELECT COUNT(*) FROM student JOIN comment ON student.id = comment.student_id JOIN comment_vote ON comment.id = comment_vote.comment_id WHERE student.id=1 AND comment_vote.vote=1;
		String query = "SELECT COUNT(s.comments.commentvotes.id) FROM Student s "
				+ "JOIN FETCH s.comments JOIN FETCH s.comments.commentvotes"
				+ "WHERE (s.id=:sid AND s.comments.commentvotes.vote=TRUE)";
		long count = em.createQuery(query, Long.class).setParameter("sid", studentId).getSingleResult();
		return (int) count;
	}

	@Override
	public int studentDownVoteTotal(int studentId) {
		String query = "SELECT COUNT(s.comments.commentvotes.id) FROM Student s "
				+ "JOIN FETCH s.comments JOIN FETCH s.comments.commentvotes"
				+ "WHERE (s.id=:sid AND s.comments.commentvotes.vote=FALSE)";
		long count = em.createQuery(query, Long.class).setParameter("sid", studentId).getSingleResult();
		return (int) count;
	}

	@Override
	public List<Student> studentsWhoUpvoted(int commentId) {
		String query = "SELECT c.commentVotes.student FROM Comment c "
				+ "JOIN FETCH c.commentVotes JOIN FETCH c.commentVotes.student" + "JOIN FETCH c.commentVotes.vote"
				+ "WHERE (c.id=:cid AND c.commentVotes.vote=TRUE";
		List<Student> students = em.createQuery(query, Student.class).setParameter("cid", commentId).getResultList();
		return students;
	}

	@Override
	public List<Comment> commentsStudentUpVoted(int studentId) {
		String query = "SELECT cv.comment FROM CommentVote cv" + "JOIN FETCH cv.comment JOIN FETCH cv.student"
				+ "WHERE cv.student.id=:sid";
		List<Comment> comments = em.createQuery(query, Comment.class).setParameter("sid", studentId).getResultList();
		return comments;
	}

}
