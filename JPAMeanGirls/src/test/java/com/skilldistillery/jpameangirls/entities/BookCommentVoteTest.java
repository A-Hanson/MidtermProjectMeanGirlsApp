package com.skilldistillery.jpameangirls.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

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
//		TODO: cannot yet write test because fields not complete (need mappings)
//		assertEquals(XXXXXXXXXX, em.find(BookCommentVote.class, XXXXXXXXXXXXX));
		fail();
	}

}
