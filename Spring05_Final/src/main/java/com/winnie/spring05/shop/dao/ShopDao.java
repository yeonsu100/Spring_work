package com.winnie.spring05.shop.dao;

import java.util.List;

import com.winnie.spring05.shop.dto.ShopDto;

public interface ShopDao {
	public List<ShopDto> getList();			// 상품의 목록을 리턴해주는 메소드
	public void minusCount(int num);		// 상품 재고를 감소시키는 메소드
	public void minusMoney(ShopDto dto);	// 잔고를 감소시키는 메소드
	public void plusPoint(ShopDto dto);		// 포인트를 증가시키는 메소드
	public int getPrice(int num);			// 특정 상품의 가격을 리턴하는 메소드
}
