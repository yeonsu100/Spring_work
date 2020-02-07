package com.winnie.spring05.users.dao;

import com.winnie.spring05.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId);
	public void insert(UsersDto dto);
	public String getPwdHash(String inputId);	// 입력한 id를 이용하여 암호화된 password를 가져오는 것 (만약 가입되지 않았으면 null이다. =로그인 실패)
	public UsersDto getData(String id);			// 인자로 전달된 id에 해당 개인정보를 리턴해주는 메소드
	public void updateProfile(UsersDto dto);
	public void updatePwd(UsersDto dto);
	public void delete(String id);
	public void updateAccount(UsersDto dto);
	public String getProfile(String id);
}
