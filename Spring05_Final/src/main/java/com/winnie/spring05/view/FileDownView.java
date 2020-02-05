package com.winnie.spring05.view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.winnie.spring05.file.dto.FileDto;

/*
 * [view를 만드는 방법]
 * 
 * - AbstractView 추상 클래스를 상속받는다.
 * - @Component("bean의 이름 지정")
 * - ModelAndView 객체에 담은 모델은 Map 객체로 전달된다.
 * - servlet-context.xml에 BeanNameViewResolver 설정
 */

@Component("fileDownView")		// bean의 이름 지정하기 (임의 지정 가능)
public class FileDownView extends AbstractView{				// AbstractView 추상 클래스 상속

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 파일 다운로드는 여기서 처리한다. (download.jsp 페이지를 별도로 작성하는 것이 아니라)
		
		// ModelAndView 객체에 담았던 값이 Map 객체에 담겨서 전달된다.
		FileDto dto=(FileDto)model.get("dto");

		// 파일 data를 응답한다. (다운로드 시켜주기) 
		String orgFileName=dto.getOrgFileName(); 		//원본 파일명
		String saveFileName=dto.getSaveFileName();		//저장된 파일명
		// ServletContext 객체의 참조값 (jsp 페이지에서는 기본 객체)
		ServletContext application=request.getServletContext();
		
		// 다운로드 시켜줄 파일의 실제 경로 구성하기
		String path=application.getRealPath("/upload")+File.separator+saveFileName;
		
		// 다운로드 할 파일을 읽어올 스트림 객체 생성하기
		FileInputStream fis=new FileInputStream(path);
		
		// 다운로드 시켜주는 작업을 한다. (실제 파일 데이터와 원본파일명을 보내줘야한다.)
		// 다운로드 시켜주는 작업을 한다. 
		String encodedName=null;
		System.out.println(request.getHeader("User-Agent"));
		// 한글 파일명 세부처리 
		if(request.getHeader("User-Agent").contains("Firefox")){
			// 벤더사가 파이어 폭스인경우 
			encodedName=new String
				(orgFileName.getBytes("utf-8"),"ISO-8859-1");
		}else{ // 그외 다른 벤더사 
			encodedName=URLEncoder.encode(orgFileName, "utf-8");
			// 파일명에 공백이있는 경우 처리 
			encodedName=encodedName.replaceAll("\\+"," ");
		}
		
		// 응답 헤더 정보 설정
		response.setHeader("Content-Disposition","attachment;filename="+encodedName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 다운로드할 파일의 크기 읽어와서 다운로드할 파일의 크기 설정
		response.setContentLengthLong(dto.getFileSize());
		
		// 클라이언트에게 출력할수 있는 스트림 객체 얻어오기
		BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
		// 한번에 최대 1M byte씩 읽어올수 있는 버퍼
		byte[] buffer=new byte[1024*1000];
		int readedByte=0;
		// 반복문 돌면서 출력
		while(true){
			// byte[] 객체를 이용해서 파일에서 byte 알갱이 읽어오기
			readedByte = fis.read(buffer);
			if(readedByte == -1)break; 		// 더이상 읽을 데이터가 없다면 반복문 빠져 나오기
			// 읽은 만큼 출력하기
			bos.write(buffer, 0, readedByte);
			bos.flush(); 					//출력
		}
		fis.close();   
	}

}
