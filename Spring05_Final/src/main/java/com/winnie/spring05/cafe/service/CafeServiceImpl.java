package com.winnie.spring05.cafe.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.winnie.spring05.cafe.dao.CafeDao;
import com.winnie.spring05.cafe.dao.CommentDao;
import com.winnie.spring05.cafe.dto.CafeDto;
import com.winnie.spring05.cafe.dto.CommentDto;
import com.winnie.spring05.exception.CanNotDeleteException;

@Service
public class CafeServiceImpl implements CafeService {
	@Autowired
	private CafeDao dao;
	@Autowired
	private CommentDao commentDao;
	
	static final int PAGE_ROW_COUNT=10;
	static final int PAGE_DISPLAY_COUNT=10;
	
	@Override
	public void getList(HttpServletRequest request) {
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		CafeDto dto=new CafeDto();
		if(keyword != null) {
			if(condition.equals("titlecontent")) {
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {
				dto.setWriter(keyword);
			}

			request.setAttribute("condition", condition);

			String encodedKeyword=null;
			try {
				encodedKeyword=URLEncoder.encode(keyword, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			request.setAttribute("encodedKeyword", encodedKeyword);
			request.setAttribute("keyword", keyword);
		}
		
		// 보여줄 페이지의 번호
		int pageNum=1;
		// 보여줄 페이지의 번호가 파라미터로 전달되는지 읽어와 본다.	
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){			// 페이지 번호가 파라미터로 넘어온다면
			// 페이지 번호 설정
			pageNum=Integer.parseInt(strPageNum);
		}
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;

		// 전체 row 의 갯수를 읽어온다.
		int totalRow=dao.getCount(dto);
		// 전체 페이지의 갯수 구하기
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		// 시작 페이지 번호
		int startPageNum=1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		// 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		// 만약 끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; 			// 보정 
		}
		// startRowNum과 endRowNum을 CafeDto 객체에 담고 
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		// startRowNum과 endRowNum에 해당하는 카페글 목록을 select 해 온다.
		List<CafeDto> list=dao.getList(dto);

		request.setAttribute("list", list);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		request.setAttribute("totalRow", totalRow);
	}

	@Override
	public void saveContent(CafeDto dto) {
		dao.insert(dto);
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		CafeDto dto=new CafeDto();
		if(keyword != null) {	
			if(condition.equals("titlecontent")) {		
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")) {
				dto.setTitle(keyword);
			}else if(condition.equals("writer")) {
				dto.setWriter(keyword);
			}
			request.setAttribute("condition", condition);

			String encodedKeyword=null;
			try {
				encodedKeyword=URLEncoder.encode(keyword, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			request.setAttribute("encodedKeyword", encodedKeyword);
			request.setAttribute("keyword", keyword);
		}		
		dto.setNum(num);

		CafeDto resultDto=dao.getData(dto);
		dao.addViewCount(num);
		request.setAttribute("dto", resultDto);
		List<CommentDto> commentList=commentDao.getList(num);
		request.setAttribute("commentList", commentList);	
	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		String id=(String)request.getSession().getAttribute("id");
		String writer=dao.getData(num).getWriter();
		if(!id.equals(writer)) {
			throw new CanNotDeleteException();
		}
		dao.delete(num);
	}

	@Override
	public void getUpdate(ModelAndView mView, int num) {
		CafeDto dto=dao.getData(num);
		mView.addObject("dto", dto);
	}

	@Override
	public void update(CafeDto dto) {
		dao.update(dto);
	}

	@Override
	public void saveComment(HttpServletRequest request) {
		// 댓글 작성자
		String writer=(String)request.getSession().getAttribute("id");
		// 댓글의 그룹번호
		int ref_group=Integer.parseInt(request.getParameter("ref_group"));
		// 댓글의 대상자 아이디
		String target_id=request.getParameter("target_id");
		// 댓글의 내용
		String content=request.getParameter("content");
		// 댓글 내에서의 그룹번호 (null이면 원글의 댓글이다)
		String comment_group=request.getParameter("comment_group");		
		// 저장할 댓글의 primary key값이 필요하다
		int seq = commentDao.getSequence();
		// 댓글 정보를 Dto에 담기
		CommentDto dto=new CommentDto();
		dto.setNum(seq);
		dto.setWriter(writer);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		dto.setRef_group(ref_group);
		
		if(comment_group==null) {			// 원글의 댓글인 경우
			// 댓글의 글번호가 댓글의 그룹 번호가 된다.
			dto.setComment_group(seq);
		}else {								// 댓글의 댓글인 경우
			// comment_group 번호가 댓글의 그룹번호가 된다.
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		// 댓글 정보를 DB에 저장한다.
		commentDao.insert(dto);		
	}

}
