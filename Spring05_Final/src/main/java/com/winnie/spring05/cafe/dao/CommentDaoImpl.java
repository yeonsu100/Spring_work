package com.winnie.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.cafe.dto.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<CommentDto> getList(int parentNum) {
		return session.selectList("comment.getList", parentNum);
	}

	@Override
	public void insert(CommentDto dto) {
		session.insert("comment.insert", dto);
	}

	@Override
	public int getSequence() {
		return session.selectOne("comment.getSequence");
	}
	
}
