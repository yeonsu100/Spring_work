package com.winnie.spring03;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Controller 어노테이션
 * 
 * - 해당 클래스가 Spring MVC 프로젝트에서 Controller가 될 수 있도록 한다.
 * - component scan을 통해서 spring bean container에서 관리가 되는 bean이 되어야 동작을 한다.
 */
@Controller
public class HomeController {	
	
	// /home.do 요청이 왔을 때 요청을 처리하게하는 @RequestMapping 어노테이션
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		
		List<String> notice=new ArrayList<>();
		notice.add("It’s a special magic at Christmastime this year.");
		notice.add("Hearts are gay and merry, and full of yuletide cheer!");
		notice.add("The sprit of the season will make our dreams come true.");
		notice.add("Memories of Christmas are here for me and you.");
		notice.add("With caroling, bells ring-a-ling, and Santa Claus will always be");
		notice.add("Part of Christmas fantasy.");
		
		// 모델을 request에 담는다
		request.setAttribute("notice", notice);
		
		/* 
		 * "home"을 리턴해주면
		 * "/WEB-INF/views/"+"home"+".jsp"와 같은 문자열이 만들어지고
		 *  /WEB-INF/views/home.jsp 페이지로 forward 이동되어서 응답된다.
		 */
		return "home";
	}
}
