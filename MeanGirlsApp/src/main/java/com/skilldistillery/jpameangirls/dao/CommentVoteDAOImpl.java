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
		String query = "SELECT COUNT(cv) FROM CommentVote cv JOIN JOIN cv.comment c WHERE (c.id=:cid AND cv.vote=TRUE";
		long count = em.createQuery(query, Long.class).setParameter("cid", commentId).getSingleResult();
		return (int) count;
	}

	@Override
	public int commentDownVoteTotal(int commentId) {
		String query = "SELECT COUNT(cv) FROM CommentVote cv JOIN cv.comment c WHERE (c.id=:cid AND cv.vote=FALSE";
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
		String query = "SELECT COUNT(cv.id) FROM Student s " + "JOIN s.comments c JOIN c.commentVotes cv "
				+ "WHERE s.id=:sid AND cv.vote=TRUE";
		long count = em.createQuery(query, Long.class).setParameter("sid", studentId).getSingleResult();
		return (int) count;
	}

	@Override
	public int studentDownVoteTotal(int studentId) {
		String query = "SELECT COUNT(cv.id) FROM Student s " + "JOIN s.comments c JOIN c.commentVotes cv "
				+ "WHERE s.id=:sid AND cv.vote=FALSE";
		long count = em.createQuery(query, Long.class).setParameter("sid", studentId).getSingleResult();
		return (int) count;
	}

	@Override
	public List<Student> studentsWhoUpvoted(int commentId) {
		String query = "SELECT s FROM Comment c "
				+ "JOIN c.commentVotes cv JOIN c.commentVotes.student s" + "JOIN c.commentVotes.vote v"
				+ "WHERE (c.id=:cid AND v=TRUE";
		List<Student> students = em.createQuery(query, Student.class).setParameter("cid", commentId).getResultList();
		return students;
	}

	@Override
	public List<Comment> commentsStudentUpVoted(int studentId) {
		String query = "SELECT c FROM CommentVote cv" + "JOIN cv.comment c JOIN cv.student s"
				+ "WHERE s.id=:sid";
		List<Comment> comments = em.createQuery(query, Comment.class).setParameter("sid", studentId).getResultList();
		return comments;
	}

}
