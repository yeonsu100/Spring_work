package com.winnie.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winnie.spring05.cafe.dto.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SqlSession session;

	// 인자로 전달된 그룹번호 (원글의 글번호)에 해당되는 댓글 목록 얻어오기
	@Override
	public List<CommentDto> getList(int ref_group) {
		return session.selectList("comment.getList", ref_group);
	}

	@Override
	public void insert(CommentDto dto) {
		session.insert("commentDto.insert", dto);
	}

	@Override
	public void update(CommentDto dto) {
		session.update("comment.update", dto);
	}

	@Override
	public void delete(int num) {
		session.update("comment.delete", num);		// 업데이트문을 수행함으로써 완전삭제하지 않고 '삭제된 댓글입니다'가 표시되도록 한다.
	}

	// 저장할 댓글의 글번호를 리턴하는 메소드
	@Override
	public int getSequence() {
		// 시퀀스 값을 얻어내서 (파라미터 타입은 없고, result type은 int이다)
		int seq=session.selectOne("comment.getSequence");
		// 리턴해준다.
		return seq;
	}

}
