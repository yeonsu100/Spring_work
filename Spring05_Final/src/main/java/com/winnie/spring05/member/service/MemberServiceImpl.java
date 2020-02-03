package com.winnie.spring05.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.member.dao.MemberDao;
import com.winnie.spring05.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	// 서비스는 dao에 의존한다.
	@Autowired
	private MemberDao dao;
	
	// 회원 목록을 인자로 전달받은 ModelAndView 객체에 담는 로직을 처리하는 서비스 메소드
	@Override
	public void getList(ModelAndView mView) {
		List<MemberDto> list=dao.getList();
		mView.addObject("list",	list);
	}
	
	// 인자로 전달되는 새로운 회원정보를 DB에 저장하는 비즈니스 로직 처리
	@Override
	public void addMember(MemberDto dto) {
		dao.insert(dto);
	}

}
