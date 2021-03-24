package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.BurnBookComment;

public interface BurnBookCommentDAO {
	
	BurnBookComment findById(int id);
	List<BurnBookComment> getAll();
	BurnBookComment create(BurnBookComment comment);
	BurnBookComment update(BurnBookComment comment);
	BurnBookComment deletePermanently(BurnBookComment comment);
	BurnBookComment deleteByIdPermanently(Integer id);
}
