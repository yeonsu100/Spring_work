package com.winnie.spring05.cafe.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SqlSession session;
}
