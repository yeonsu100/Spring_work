package com.winnie.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;
	@Override
	public boolean isExist(String inputId) {
		// 인자로 전달되는 아이디를 이용해서 select를 한다.
		String id=session.selectOne("users.isExist", inputId);
		// 만일 select된 결과가 null이면 존재하지 않는 아이디이다.
		if(id==null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

	@Override
	public String getPwdHash(String inputId) {
		// 입력한 아이디를 이용해서 저장된 비밀번호를 select한다.
		// 만일 존재하지 않는 아이디이면 null이다. (=로그인 실패, select할 것이 없다.)
		String savedPwd=session.selectOne("users.getPwdHash", inputId);
		// select된 비밀번호를 리턴해준다.
		return savedPwd;
	}

	@Override
	public UsersDto getData(String id) {
		return session.selectOne("users.getData", id);
	}

	@Override
	public void updateProfile(UsersDto dto) {
		session.update("users.updateProfile", dto);
	}

	@Override
	public void updatePwd(UsersDto dto) {
		session.update("users.updatePwd", dto);
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}

	@Override
	public void updateAccount(UsersDto dto) {
		session.update("users.updateAccount", dto);
	}

	@Override
	public String getProfile(String id) {
		return session.selectOne("users.getProfile",id);
	}

}
