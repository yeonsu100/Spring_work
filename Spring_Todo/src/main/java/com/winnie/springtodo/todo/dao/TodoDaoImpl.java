package com.winnie.springtodo.todo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.springtodo.todo.dto.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<TodoDto> getList() {
		List<TodoDto> list=session.selectList("todo.getList");
		return list;
	}

	@Override
	public void delete(int num) {
		session.delete("todo.delete", num);
	}

}
