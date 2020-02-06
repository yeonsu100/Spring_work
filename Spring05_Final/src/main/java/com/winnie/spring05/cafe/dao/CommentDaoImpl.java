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
	
}
