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


}
