package com.skilldistillery.jpameangirls.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommentVoteTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private CommentVote cv;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("MeanGirls");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		cv = em.find(CommentVote.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cv = null;
	}

	@Test
	@DisplayName("Test CommentVote entity mapping")
	void test1() {
		assertNotNull(cv);
		assertEquals(true, cv.getVote());
	}
	
	@Test
	@DisplayName("Test CommentVote entity mapping")
	void test2() {
		assertNotNull(cv);
		assertEquals("Hi everyone! i cant help that im so popular",cv.getComment().getContent());
	}

	@Test
	@DisplayName("Test CommentVote - Student mapping")
	void test3() {
		assertNotNull(cv);
		assertEquals("Regina", cv.getStudent().getFirstName());
		/*
		 * mysql> select * from student join comment_vote on student.id = comment_vote.student_id where comment_vote.id = 1;
+----+---------+------------+-----------+--------+-------------+---------------------+---------------+------------------------------------------------------------------------+----+------+------------+------------+
| id | user_id | first_name | last_name | gender | grade_level | created_date        | birthday_date | image_url                                                              | id | vote | student_id | comment_id |
+----+---------+------------+-----------+--------+-------------+---------------------+---------------+------------------------------------------------------------------------+----+------+------------+------------+
|  1 |       2 | Regina     | George    | Female |          11 | 2020-03-19 00:00:00 | 1991-01-01    | https://smulook.com/wp-content/uploads/2020/09/regina-on-the-phone.jpg |  1 |    1 |          1 |          1 |
+----+---------+------------+-----------+--------+-------------+---------------------+---------------+------------------------------------------------------------------------+----+------+------------+------------+
1 row in set (0.00 sec)

		 */
	}

}
