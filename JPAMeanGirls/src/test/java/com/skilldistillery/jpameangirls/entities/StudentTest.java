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
}
