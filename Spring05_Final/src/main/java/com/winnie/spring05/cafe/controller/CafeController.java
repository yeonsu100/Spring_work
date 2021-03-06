package com.winnie.spring05.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.cafe.dto.CafeDto;
import com.winnie.spring05.cafe.dto.CommentDto;
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
	
	@RequestMapping("/cafe/detail")
	public String detail(HttpServletRequest request){
		service.getDetail(request);
		// view page로 forward 이동해서 글 자세히 보기 
		return "cafe/detail";
	}
	
	@RequestMapping("/cafe/delete")
	public ModelAndView authDelete(@RequestParam int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	@RequestMapping("/cafe/updateform")
	public ModelAndView authUpdateForm(ModelAndView mView, @RequestParam int num, 
			HttpServletRequest request) {
		service.getUpdate(mView, num);
		mView.setViewName("cafe/updateform");
		return mView;
	}
	
	@RequestMapping("/cafe/update")
	public ModelAndView authUpdate(@ModelAttribute CafeDto dto, HttpServletRequest request) {
		service.update(dto);
		return new ModelAndView("redirect:/cafe/detail.do?num="+dto.getNum());
	}
	
	// 댓글 저장 요청 처리
	@RequestMapping(value = "/cafe/comment_insert", method = RequestMethod.POST)
	public ModelAndView authCommentInsert(HttpServletRequest request, @RequestParam int ref_group) {
		service.saveComment(request);
		return new ModelAndView("redirect:/cafe/detail.do?num="+ref_group);
	}
	
	// 댓글 삭제 요청 처리 (ajax)
	@ResponseBody
	@RequestMapping(value="/cafe/comment_delete", method = RequestMethod.POST)
	public Map<String, Object> authCommentDelete(HttpServletRequest request, @RequestParam int num){
		service.deleteComment(num);
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", true);
		return map;				// {"isSuccess" : true} 형식의 JSON 문자열이 응답된다.
	}
	
	// 댓글 수정 요청 처리 (ajax)
	@ResponseBody
	@RequestMapping("/cafe/comment_update")
	public Map<String, Object> suthCommentUpdate(HttpServletRequest request, @ModelAttribute CommentDto dto) {
		service.updateComment(dto);
		Map<String, Object> map=new HashMap<>();
		map.put("isSuccess", true);
		return map;
	}
	
}
