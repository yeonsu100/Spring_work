package com.winnie.springtodo.todo.dao;

import java.util.List;

import com.winnie.springtodo.todo.dto.TodoDto;

public interface TodoDao {
	public List<TodoDto> getList();
	public void delete(int num);
}
