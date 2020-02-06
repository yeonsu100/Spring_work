package com.winnie.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public int getCount(CafeDto dto) {
		int count=session.selectOne("cafe.getCount", dto);
		return count;
	}

	@Override
	public List<CafeDto> getList(CafeDto dto) {
		List<CafeDto> list=session.selectList("cafe.getList", dto);
		return list;
	}

	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
	}

	@Override
	public CafeDto getData(CafeDto dto) {
		return session.selectOne("cafe.getData", dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("cafe.addViewCount", num);
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete", num);
	}

}
