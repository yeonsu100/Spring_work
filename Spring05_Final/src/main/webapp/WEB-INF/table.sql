CREATE TABLE board_cafe(
	num NUMBER PRIMARY KEY,
	writer VARCHAR2(100) NOT NULL,		-- 글 작성자 id
	title VARCHAR2(100) NOT NULL,
	content CLOB,
	viewCount NUMBER,					-- 조회수
	regdate DATE
);

CREATE SEQUENCE board_cafe_seq;


CREATE TABLE board_file(
num	NUMBER PRIMARY KEY,
writer VARCHAR2(100),
title VARCHAR2(100) NOT NULL,
orgFileName VARCHAR2(100) NOT NULL,		-- 원본 파일명
saveFileName VARCHAR2(100) NOT NULL,	-- 파일 시스템에 실제 저장된 파일명
fileSize NUMBER,						-- 파일의 크기 (byte)
downCount NUMBER DEFAULT 0,				-- 다운로드 횟수
regdate DATE
);

CREATE SEQUENCE board_file_seq;


ALTER TABLE users ADD(profile VARCHAR2(50));

-- 댓글 정보를 저장할 테이블 (기존에 내가 만들었던 board_cafe_comment는 삭제하지 않고 일단 보류한다)
CREATE TABLE board_cafe_comment2(
	num NUMBER PRIMARY KEY,			-- 댓글의 글번호
	writer VARCHAR2(100),			-- 댓글 작성자
	content VARCHAR2(500),			-- 댓글 내용
	target_id VARCHAR2(100),		-- 댓글의 대상이 되는 아이디
	ref_group NUMBER,				-- 댓글 그룹번호
	comment_group NUMBER,			-- 원글에 달린 댓글 내에서의 그룹 번호
	deleted CHAR(3) DEFAULT 'no',	-- 댓글이 삭제되었는지 여부
	regdate DATE					-- 댓글 등록일
);

CREATE SEQUENCE board_cafe_comment2_seq;

DELETE FROM shop;
DELETE FROM client_account;


-- 상품 테이블
CREATE TABLE shop(
	num NUMBER PRIMARY KEY, 					--상품번호
	name VARCHAR2(30), 							--상품이름
	price NUMBER, 								--상품가격
	remainCount NUMBER CHECK(remainCount >= 0) 	--재고갯수 
);

-- 고객 계좌 테이블 (가상의 계좌 테이블)
CREATE TABLE client_account(
	id VARCHAR2(30) PRIMARY KEY,				-- 고객의 아이디
	money NUMBER CHECK(money >= 0), 			-- 고객의 잔고 
	point NUMBER
);

-- 주문 테이블
CREATE TABLE client_order(
	num NUMBER PRIMARY KEY, 					-- 주문번호
	id VARCHAR2(30), 							-- 주문 고객의 아이디
	code NUMBER, 								-- 주문한 상품의 번호 
	addr VARCHAR2(50) 							-- 배송 주소
);

-- 주문 테이블에 사용할 시퀀스 
CREATE SEQUENCE client_order_seq;


-- sample 데이터
INSERT INTO shop (num,name,price,remainCount)
VALUES(1, 'apple', '1000', 5);

INSERT INTO shop (num,name,price,remainCount)
VALUES(2, 'banana', '2000', 5);

INSERT INTO shop (num,name,price,remainCount)
VALUES(3, 'orange', '3000', 5);

INSERT INTO client_account (id, money, point)
VALUES('superman', 10000, 0);

INSERT INTO client_account (id, money, point)
VALUES('batman', 10000, 0);