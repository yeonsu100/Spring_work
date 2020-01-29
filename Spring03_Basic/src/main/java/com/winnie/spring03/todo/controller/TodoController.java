package com.winnie.spring03.todo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 1. Controller 어노테이션
@Controller
public class TodoController {
	// 2. RequestMapping 어노테이션으로 요청 맵핑하기
	@RequestMapping("/todo/list.do")
	public String list(HttpServletRequest request) {
		
		// 3. 할 일 목록을 얻어오는 비즈니스 로직 처리하기
		List<String> todoList=new ArrayList<String>();
		todoList.add("study on HTML");
		todoList.add("study on CSS");
		todoList.add("study on Javascript");
		todoList.add("study on JAVA");
		todoList.add("study on Python");
		todoList.add("study on LINUX");
		todoList.add("Study hard! Cheer Up WINNIE!!");
		
		// 4. 비즈니스 로직 처리 결과 모델을 request에 담기
		request.setAttribute("todoList", todoList);
		
		// 5. view page의 정보를 리턴하면 해당 페이지로 forward 이동해서 응답이 된다
		return "todo/list";
	}
	
	
	@RequestMapping("/todo/list2")	// .do는 생략 가능!
	public ModelAndView list2() {	// ModelAndView는 스프링 프레임워크에서 제공하는 객체이므로 사용하기 좀 더 편리하다
		// Model
		List<String> todoList=new ArrayList<String>();
		todoList.add("Study hard! Cheer Up WINNIE!!");
		todoList.add("study on HTML");
		todoList.add("study on CSS");
		todoList.add("study on Javascript");
		todoList.add("study on JAVA");
		todoList.add("study on Python");
		todoList.add("study on LINUX");
		
		// Model과 view page 정보를 담을 수 있는 객체 생성
		ModelAndView mView=new ModelAndView();
		// ModelAndView 객체에 .addObject(key, value)로 담은 객체는 자동으로 request 객체에 담긴다.
		mView.addObject("todoList", todoList);
		// view page 정보도 .setViewName() 메소드를 이용해서 담는다.
		mView.setViewName("todo/list");
		// Model과 view page 정보가 담긴 객체를 리턴해준다.
		return mView;
	}
	
	
	// 메소드의 인자로 ModelAndView 객체를 받을 수 있는 변수를 선언하면 
	// 스프링 프레임워크가 해당 객체를 생성해서 인자로 전달해준다. (스프링에서 가장 흔하게 사용되는 형태)
	@RequestMapping("/todo/list3")
	public ModelAndView list3(ModelAndView mView) {
		// Model
		List<String> todoList=new ArrayList<String>();
		todoList.add("Study hard! Cheer Up WINNIE!!");
		todoList.add("study on HTML");
		todoList.add("study on CSS");
		todoList.add("study on Javascript");
		todoList.add("study on JAVA");
		todoList.add("study on Python");
		todoList.add("study on LINUX");
		// 인자로 전달받은 객체에 Model을 담고
		mView.addObject("todoList", todoList);
		// 인자로 전달받은 객체에 view page의 정보를 담고
		mView.setViewName("/todo/list");
		// 인자로 전달받은 객체의 참조값을 리턴해준다.
		return mView;
	}
	
	
}
