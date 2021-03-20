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

class BadgeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Badge badge;
	
	
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
		badge = em.find(Badge.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		badge = null;
	}

	/*
	 * mysql> SELECT * FROM badge;
+----+-----------+--------------------------------------+------------------------------------------------------------------------+
| id | name      | description                          | image_url                                                              |
+----+-----------+--------------------------------------+------------------------------------------------------------------------+
|  1 | First Day | First day at North Shore High School | https://smulook.com/wp-content/uploads/2020/09/regina-on-the-phone.jpg |
+----+-----------+--------------------------------------+------------------------------------------------------------------------+
	 */
	
	@Test
	@DisplayName("Test Badge entity mapping")
	void test_1() {
		assertNotNull(badge);
		assertEquals("First day at North Shore High School", badge.getDescription());
	}
	
	@Test
	@DisplayName("Test Badge to Student mapping")
	void test_2() {
		assertNotNull(badge);
		assertNotNull(badge.getStudents());
		assertTrue(badge.getStudents().size() > 0);
	}

}
