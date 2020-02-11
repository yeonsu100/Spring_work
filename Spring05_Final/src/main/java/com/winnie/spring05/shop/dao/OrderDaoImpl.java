package com.winnie.spring05.shop.dao;

import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.exception.NoDeliveryException;
import com.winnie.spring05.shop.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao {
	// 의존 객체
	@Autowired
	private SqlSession session;

	@Override
	public void addOrder(OrderDto dto) {
		// 테스트를 위해 50%의 확률로 예외 발생시키기 (공부하기 위해 임의로 예외를 발생시킨 것)
		Random ran=new Random();
		int ranNum=ran.nextInt(2);
		if(ranNum==0) {
			throw new NoDeliveryException("Sorry! It's impossible to delivery.");
		}
				
		// 주문 테이블에 주문 추가
		session.insert("shop.addOrder", dto);
	}

}
