package com.winnie.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import com.winnie.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request);
	public void saveContent(CafeDto dto);
}
