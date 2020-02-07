package com.winnie.spring05.cafe.dao;

import java.util.List;

import com.winnie.spring05.cafe.dto.CafeDto;

public interface CafeDao {
	public int getCount(CafeDto dto);				// 글의 갯수
	public List<CafeDto> getList(CafeDto dto);		// 글의 목록
	public void insert(CafeDto dto);				// 새 글 추가
	public CafeDto getData(CafeDto dto);			// 글 정보 얻어오기
	public void addViewCount(int num);				// 조회수 증가시키기
	public void delete(int num);					// 글 삭제하기
	public CafeDto getData(int num);				// 글 한개의 정보
	public void update(CafeDto dto);				// 글 내용 수정하기
}
