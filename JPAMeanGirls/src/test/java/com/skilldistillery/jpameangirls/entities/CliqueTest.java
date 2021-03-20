package com.skilldistillery.jpameangirls.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CliqueTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Clique clique;

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
		clique = em.find(Clique.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		clique = null;
	}

	@Test
	@DisplayName("Test Clique mapping")
	void test_1() {
		assertNotNull(clique);
		assertEquals("Cafeteria", clique.getName());
		assertEquals(-500, clique.getMinimumFetchLevel());
		assertEquals("Place to eat and talk", clique.getDescription());
	}

	@Test
	@DisplayName("Test clique-student mapping")
	void test2() {
		assertNotNull(clique);
		assertNotNull(clique.getStudents());
		assertTrue(clique.getStudents().size() > 0);
	}
	
	@Test
	@DisplayName("Test clique-comment mapping")
	void test3() {
		assertNotNull(clique);
		assertNotNull(clique.getComments());
		assertTrue(clique.getComments().size() > 0);
	}
	
	
}
