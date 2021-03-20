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

class StudentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Student student;
	
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
		student = em.find(Student.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		student = null;
	}

	@Test
	@DisplayName("Test Student Mapping to not null")
	void test1() {
		assertNotNull(student);
	}

	@Test
	@DisplayName("Test Student property Mapping")
	void test2() {
		assertEquals("Regina", student.getFirstName());
		assertEquals("George", student.getLastName());
		assertEquals("Female", student.getGender());
		assertEquals(11, student.getGradeLevel());
		assertEquals(19, student.getCreatedDate().getDayOfMonth());
	}
	
	@Test
	@DisplayName("Test Student User Mapping")
	void test3() {
		assertNotNull(student.getUser());
		assertEquals("user2020", student.getUser().getUsername());
	}
	
	@Test
	@DisplayName("Test Student badge Mapping")
	void test4() {
		assertNotNull(student.getBadges());
		assertTrue(student.getBadges().size() > 0);
	}
	
	@Test
	@DisplayName("Test Student Clique Mapping")
	void test5() {
		assertNotNull(student.getCliques());
		assertTrue(student.getCliques().size() > 0);
	}
	
	@Test
	@DisplayName("Test Student Comment Mapping")
	void test6() {
		assertNotNull(student.getComment());
		assertTrue(student.getComment().size() > 0);
	}
	
}
