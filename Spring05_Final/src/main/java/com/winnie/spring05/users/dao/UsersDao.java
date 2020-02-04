package com.winnie.spring05.users.dao;

import com.winnie.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public void insert(UsersDto dto);
	public String getPwdHash(String inputId);	// 입력한 id를 이용하여 암호화된 password를 가져오는 것 (만약 가입되지 않았으면 null이다. =로그인 실패)
	public UsersDto getData(String id);
}
