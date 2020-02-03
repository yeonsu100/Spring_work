package com.winnie.spring05.member.service;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public void getList(ModelAndView mView);		// 회원 목록 얻어오기 처리를 하는 메소드 (mView에 dao를 이용해 회원 목록을 담는다)
}
