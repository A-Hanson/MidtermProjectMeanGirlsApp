package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.Clique;
import com.skilldistillery.jpameangirls.entities.Student;

public interface CliqueDAO {

	Clique findById(int id);
	List<Clique> getAll();
	List<Clique> findByStudent(Student student);
	Clique create(Clique clique);
	Clique update(Clique clique);
	Clique deletePermanently(Clique clique);
	Clique deleteByIdPermanently(Integer id);
}
