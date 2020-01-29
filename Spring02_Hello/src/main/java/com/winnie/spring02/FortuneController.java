package com.winnie.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 클래스를 만들고 Controller 어노테이션을 붙여준다.
@Controller
public class FortuneController {

	// 2. RequestMapping 어노테이션을 메소드에 작성하고 어떤 요청을 처리할지 명시한다.
	@RequestMapping("/fortune.do")
	public String fortune(HttpServletRequest request) {			// 메소드명은 마음대로 지을 수 있다.
		
		/*
		 * view page에 모델 (data)를 전달해야 한다.
		 * 여기서 모델은 오늘의 운세 (String)이다.
		 * HttpServletRequest에 담으면 view page에서 사용할 수 있다.
		 */
		request.setAttribute("fortuneToday", "A smile is your passport into the hearts of others.");
		
		// 3. view page정보를 리턴해준다.
		return "fortune";
	}
}
