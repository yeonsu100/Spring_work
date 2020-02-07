package com.winnie.spring05.cafe.dao;

import java.util.List;

import com.winnie.spring05.cafe.dto.CommentDto;

public interface CommentDao {
	public List<CommentDto> getList(int ref_group);
	public void insert(CommentDto dto);
	public void update(CommentDto dto);
	public void delete(int num);
	public int getSequence();
}
