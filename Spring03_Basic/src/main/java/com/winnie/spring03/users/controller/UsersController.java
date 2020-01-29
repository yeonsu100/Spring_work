package com.winnie.spring03.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {	
	// 로그인 폼 요청처리
	@RequestMapping("/users/loginform")		// .do 생략!
	public String loginform() {
		// 수행할 비즈니스 로직은 없다.
		// request 영역에 담을 모델도 없다.
		
		// view page의 정보만 단순히 리턴해주는 경우도 있다.
		return "users/loginform";
	}
	
	
	// 로그인 요청 처리
	@RequestMapping("/users/login")
	public String login(HttpServletRequest request, 
				HttpSession session) {
		// 폼 전송되는 파라미터를  추출한다. 
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		// 유효한 정보인지 여부
		boolean isSuccess=false;
		if(id.equals("winnie") && pwd.equals("1234")) {
			isSuccess=true;
			// 로그인 처리를 한다
			session.setAttribute("id", id);
		}
		// 로그인 성공 여부를 request 에 담는다.
		request.setAttribute("isSuccess", isSuccess);
		// view page 의 정보를 리턴한다.
		return "users/login";
	}
	
	
}
