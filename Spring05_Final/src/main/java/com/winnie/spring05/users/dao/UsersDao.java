package com.winnie.spring05.users.dao;

import com.winnie.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public void insert(UsersDto dto);
}
