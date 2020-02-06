package com.winnie.spring05.cafe.dto;

public class CommentDto {
	private int num;
	private String writer;
	private String content;
	private String parentId;
	private int parentNum;
	private String regdate;
	
	public CommentDto() {}

	public CommentDto(int num, String writer, String content, String parentId, int parentNum, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.parentId = parentId;
		this.parentNum = parentNum;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getParentNum() {
		return parentNum;
	}

	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
