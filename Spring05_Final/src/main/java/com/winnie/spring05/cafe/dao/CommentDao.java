package com.winnie.spring05.cafe.dao;

import java.util.List;

import com.winnie.spring05.cafe.dto.CommentDto;

public interface CommentDao {
	public List<CommentDto> getList(int parentNum);
	public void insert(CommentDto dto);
	public int getSequence();
}
