package com.winnie.spring03.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring03.users.dto.UsersDto;

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
	
	/*
	 * @RequestParam 어노테이션은 전송되는 파라미터를 자동으로 추출할 때 사용한다.
	 * 단, 지역 변수의 이름은 파라미터의 이름과 같아야한다.
	 */
	@RequestMapping("/users/login2")
	public ModelAndView login2(@RequestParam String id, 
			@RequestParam String pwd, HttpSession session,
			ModelAndView mView) {		// 파라미터들은  하나씩 추출할수도 있다.
							// 파라미터명과 지역변수명을 똑같이 해놓으면 자동으로 추출된다.
		// 유효한 정보인지 여부
		boolean isSuccess=false;
		if(id.equals("winnie") && pwd.equals("1234")) {
			isSuccess=true;
			// 로그인 처리를 한다
			session.setAttribute("id", id);
		}
		// view 페이지에서 필요한 모델을 담고
		mView.addObject("isSuccess", isSuccess);
		// view의 정보도 담고
		mView.setViewName("users/login");
		// 리턴해준다.
		return mView;
}
	
	/*
	 * @ModelAttribute 어노테이션과 함께 dto를 메소드의 인자로 선언하면
	 * 전송되는 파라미터가 자동 추출되어서 Dto 객체에 담겨 인자로 전달된다.
	 * 단, 전송되는 파라미터명과 Dto의 필드명이 같아야한다.
	 */
	@RequestMapping("/users/login3")
	public ModelAndView login3(@ModelAttribute UsersDto dto,
			HttpSession session, ModelAndView mView) {
		// 유효한 정보인지 여부
		boolean isSuccess=false;
		if(dto.getId().equals("winnie") && dto.getPwd().equals("1234")) {
			isSuccess=true;
			// 로그인 처리를 한다
			session.setAttribute("id", dto.getId());
		}
		// view 페이지에서 필요한 모델을 담고
		mView.addObject("isSuccess", isSuccess);
		// view의 정보도 담고
		mView.setViewName("users/login");
		// 리턴해준다.
		return mView;
	}
	
	
	// 로그아웃 요청을 처리하는 메소드
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();		// 로그아웃은 세션을 초기화하면 된다
		/*
		 * forward 이동이 아닌 리다일렉트 이동 응답을 하려면
		 * view page의 정보를 
		 * 
		 * "redirect: 리다일렉트 시킬 절대 경로"
		 * 
		 * 형식으로 작성하면 된다.
		 * 단, context path는 작성하지 않는다. (자동으로 붙기 때문)
		 * (즉, 아래의 경우 "redirect:/spring03/home.do"가 아니라는 의미)
		 */
		return "redirect:/home.do";
	}
	
}
