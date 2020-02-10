package com.winnie.spring05.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.shop.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao {
	// 의존 객체
	@Autowired
	private SqlSession session;

	@Override
	public void addOrder(OrderDto dto) {
		// 주문 테이블에 주문 추가
		session.insert("shop.addOrder", dto);
	}

}
