package com.winnie.springtodo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.springtodo.todo.dao.TodoDao;
import com.winnie.springtodo.todo.dto.TodoDto;

@Controller
public class TodoController {
	@Autowired
	private TodoDao dao;
	
	@RequestMapping("/todo/list")
	public ModelAndView list(ModelAndView mView) {
		List<TodoDto> list=dao.getList();
		mView.addObject("list", list);
		mView.setViewName("todo/list");
		return mView;
	}
	
	@RequestMapping("/todo/delete")
	public String delete(@RequestParam int num) {
		dao.delete(num);
		return "redirect:/todo/list.do";
	}
	
	@RequestMapping("/todo/insertform")
	public String insertform() {
		return "todo/insertform";
	}
	
	@RequestMapping("/todo/insert")
	public ModelAndView insert(@ModelAttribute("dto") TodoDto dto,
			ModelAndView mView) {
		dao.insert(dto);
		mView.setViewName("/todo/insert"); 
		return mView;
	}
	
	@RequestMapping("/todo/updateform")
	public ModelAndView updateform(@RequestParam int num,
			ModelAndView mView) {
		TodoDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		mView.setViewName("todo/updateform");
		return mView;
	}
	
}
