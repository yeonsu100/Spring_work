package com.winnie.spring05.users.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.users.dto.UsersDto;

public interface UsersService {
	public Map<String, Object> isExistId(String inputId);
	public void addUser(UsersDto dto);
	public void validUser(UsersDto dto, HttpSession session, ModelAndView mView);
	public void showInfo(String id, ModelAndView mView);
}
