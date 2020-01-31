package com.winnie.spring05.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.member.dao.MemberDao;
import com.winnie.spring05.member.dto.MemberDto;

@Controller		// 지금은 타입이 하나이므로 @Controller를 사용하지만  여러개일 경우 @Repository("myOracle") 이런식으로 이름을 붙여 사용할 수 있다.
public class MemberController {
	// 의존 객체 주입받기 (DI)
	@Autowired		// 타입이 하나인 경우 @Autowired 사용
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
	
	// 회원정보 삭제 요청처리 - DELETE
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {			// member/delete.do?num=${tmp.num }
		// MemberDao 객체를 이용해서 회원정보 삭제
		dao.delete(num);
		// 리다일렉트 응답
		return "redirect:/member/list.do";
	}
	
	// 회원정보 추가 요청처리 - INSERT
	@RequestMapping("/member/insertform")
	public String insertform() {
		// 수행할 비즈니스 로직은 없으므로 view 페이지만 리턴해주면 된다.
		return "member/insertform";
	}
	/*
	 * ModelAttribute MemberDto dto를 메소드의 인자로 선언하면 
	 * 폼 전송되는 파라미터가 자동으로 MemberDto 객체에 setter 메소드를 통해서 들어가고
	 * 그 객체가 메소드의 인자로 전달된다.
	 * 단, 파라미터명과 Dto의 필드명이 일치해야 한다. 
	 */
	@RequestMapping("/member/insert")
	public ModelAndView insert(@ModelAttribute("dto") MemberDto dto,
			ModelAndView mView) {
		dao.insert(dto);
		/*
		 * @ModelAttribute("dto") MemberDto dto의 의미는
		 * 1. 전송되는 파라미터를 자동으로 추출해서 MemberDto에 담아주기도하고
		 * 2. "dto"라는 키값으로 MemberDto 객체를 request영역에 담아주는 역할도 한다.
		 */
		// mView.addObject("dto", dto);
		mView.setViewName("/member/insert"); 		// 여기는 리다일렉트 이동하지 않고 insert.jsp로 보내 메세지를 띄워본다.
		return mView;
	}
	
	// 회원정보 업데이트 요청처리
//	@RequestMapping("/member/update")
//	public String update(@RequestParam int num) {
//		dao.update(num);
//		return "redirect:/member/list.do";
//	}
	
}
