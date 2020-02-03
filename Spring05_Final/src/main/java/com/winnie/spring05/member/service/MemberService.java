package com.winnie.spring05.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.member.dto.MemberDto;

public interface MemberService {
	public void getList(ModelAndView mView);	// 회원 목록 얻어오기 처리를 하는 메소드 (mView에 dao를 이용해 회원 목록을 담는다)
	public void addMember(MemberDto dto);		// 회원정보를 추가하는 메소드 (메소드명은 임의로 짓는다)
	public void getMember(ModelAndView mView, int num);		// 번호를 전달하면 해당하는 회원정보를 select하여 mView에 담는 메소드
	public void updateMember(MemberDto dto);		// DB에 수정반영하는 메소드
	public void deleteMember(int num);				// 회원정보를 삭제하는 메소드
}
