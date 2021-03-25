package com.skilldistillery.jpameangirls.dao;

import java.util.List;

import com.skilldistillery.jpameangirls.entities.BurnBookComment;
import com.skilldistillery.jpameangirls.entities.Comment;

public interface BurnBookCommentDAO {
	
	BurnBookComment findById(int id);
	List<BurnBookComment> getAll();
	List<BurnBookComment> getAllFlagged();
	List<BurnBookComment> getAllEnabled();
	List<BurnBookComment> getAllEnabledAndFlagged();
	BurnBookComment create(BurnBookComment comment);
	BurnBookComment update(BurnBookComment comment);
	BurnBookComment deletePermanently(BurnBookComment comment);
	BurnBookComment deleteByIdPermanently(Integer id);
}
