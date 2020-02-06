package com.winnie.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.cafe.dto.CafeDto;
import com.winnie.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService service;
	
	@RequestMapping("/cafe/list")
	public ModelAndView getList(HttpServletRequest request) {
		service.getList(request);
		return new ModelAndView("cafe/list");
	}
	
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInsertform(HttpServletRequest request) {
		return new ModelAndView("cafe/insertform");
	}
	
	@RequestMapping("/cafe/insert")
	public ModelAndView authInsert(@ModelAttribute CafeDto dto,HttpServletRequest request) {
		String id=(String)request.getSession().getAttribute("id");
		dto.setWriter(id);
		service.saveContent(dto);
		return new ModelAndView("redirect:/cafe/list.do");
	}
}
