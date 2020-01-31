package com.winnie.spring05.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	// 핵심 의존 객체를 spring으로 부터 주입받기 (Dependency Injection)
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public void insert(MemberDto dto) {			// dto : parameterType
		session.insert("member.insert", dto);	// .insert : sql id
	}
	
	
//	@Override
//	public void update(int num) {
//		session.update("member.update", num);
//	}

}
