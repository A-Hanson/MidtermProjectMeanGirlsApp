package com.skilldistillery.jpameangirls.dao;

import com.skilldistillery.jpameangirls.entities.User;

public interface UserDAO {
	
	User findById(int userId);
}
