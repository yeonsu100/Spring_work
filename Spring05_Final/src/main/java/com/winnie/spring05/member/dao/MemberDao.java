package com.winnie.spring05.member.dao;

import java.util.List;

import com.winnie.spring05.member.dto.MemberDto;

public interface MemberDao {
	public List<MemberDto> getList();
	public void delete(int num);
}
