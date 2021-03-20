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

class BurnBookCommentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private BurnBookComment comment;
	
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
		comment = em.find(BurnBookComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		comment = null;
	}

	@Test
	@DisplayName("Test BurnBookComment Mapping")
	void test_1() {
		assertNotNull(comment);
		assertEquals("Regina George is super fetch", comment.getContent());
		assertTrue(comment.getEnabled());
		assertFalse(comment.getFlagged());
		assertEquals(1, comment.getAuthorId());
		assertEquals(2020, comment.getCreatedDate().getYear());
		assertEquals(3, comment.getCreatedDate().getMonthValue());
		assertEquals(19, comment.getCreatedDate().getDayOfMonth());
		assertEquals(1, comment.getStudentId());
		assertTrue(comment.getVote());
	}

}
