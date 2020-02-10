package com.winnie.spring05.shop.dao;

import com.winnie.spring05.shop.dto.OrderDto;

public interface OrderDao {
	// 배송정보를 추가하는 메소드
	public void addOrder(OrderDto dto);
}
