package com.skilldistillery.jpameangirls.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookCommentVoteTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private BookCommentVote bcv;
	
	
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
		bcv = em.find(BookCommentVote.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		bcv = null;
	}

	/*
	 * mysql> SELECT * FROM book_comment_vote ;
+----+------+----------------------+------------+
| id | vote | burn_book_comment_id | student_id |
+----+------+----------------------+------------+
|  1 |    1 |                    1 |          1 |
+----+------+----------------------+------------+
1 row in set (0.00 sec)

	 */
	
	@Test
	@DisplayName("Test Badge entity mapping")
	void test() {
		assertNotNull(bcv);
		assertEquals(true, bcv.getVote());
	}

	
	@Test
	@DisplayName("Test BCV to BBC mapping")
	void test1() {
		assertNotNull(bcv);
		assertEquals("Regina George is super fetch", bcv.getBurnBookCommentId().getContent());
	}
	/*
	 * mysql> select * from burn_book_comment join book_comment_vote on book_comment_vote.burn_book_comment_id = burn_book_comment.id where book_comment_vote.id = 1;
+----+------------------------------+---------+---------+-----------+---------------------+------------+------+----+------+----------------------+------------+
| id | content                      | enabled | flagged | author_id | created_date        | student_id | vote | id | vote | burn_book_comment_id | student_id |
+----+------------------------------+---------+---------+-----------+---------------------+------------+------+----+------+----------------------+------------+
|  1 | Regina George is super fetch |       1 |       0 |         1 | 2020-03-19 00:00:00 |          1 |    1 |  1 |    1 |                    1 |          1 |
+----+------------------------------+---------+---------+-----------+---------------------+------------+------+----+------+----------------------+------------+
1 row in set (0.00 sec)

	 */
	
}
