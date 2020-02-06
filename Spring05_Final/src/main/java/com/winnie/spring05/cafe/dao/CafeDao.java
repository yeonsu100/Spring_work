package com.winnie.spring05.cafe.dao;

import java.util.List;

import com.winnie.spring05.cafe.dto.CafeDto;

public interface CafeDao {
	public int getCount(CafeDto dto);
	public List<CafeDto> getList(CafeDto dto);
	public void insert(CafeDto dto);
	public CafeDto getData(CafeDto dto);
	public void addViewCount(int num);
	public void delete(int num);
}
