package com.winnie.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(HttpServletRequest request);
	public void saveContent(CafeDto dto);
	public void getDetail(HttpServletRequest request);
	public void deleteContent(int num);
	public void getUpdate(ModelAndView mView, int num);
	public void update(CafeDto dto);
}
