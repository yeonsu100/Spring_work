package com.winnie.springtodo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {	
	
	@RequestMapping("/home.do")
	public String home(HttpServletRequest request) {
		
		List<String> notice=new ArrayList<>();
		notice.add("It’s a special magic at Christmastime this year.");
		notice.add("Hearts are gay and merry, and full of yuletide cheer!");
		notice.add("The sprit of the season will make our dreams come true.");
		notice.add("Memories of Christmas are here for me and you.");
		notice.add("With caroling, bells ring-a-ling, and Santa Claus will always be");
		notice.add("Part of Christmas fantasy.");
		
		request.setAttribute("notice", notice);
		
		return "home";
	}
	
}
