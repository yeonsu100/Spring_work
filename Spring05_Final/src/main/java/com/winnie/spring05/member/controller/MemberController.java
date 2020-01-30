package com.winnie.spring05.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.member.dao.MemberDao;
import com.winnie.spring05.member.dto.MemberDto;

@Controller
public class MemberController {
	// 의존 객체 주입받기 (DI)
	@Autowired
	private MemberDao dao;
	
	// 회원 목록보기 요청 (/member/list.do)을 처리할 컨트롤러의 메소드
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		// 회원 목록을 얻어오려면?
		List<MemberDto> list=dao.getList();
		
		mView.addObject("list", list);
		mView.setViewName("member/list");		// WEB-INF/views/member/list.jsp 를 의미한다
		return mView;
	}
}
