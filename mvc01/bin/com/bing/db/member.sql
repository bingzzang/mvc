-- member table
CREATE TABLE TBL_MEMBER(
  NUM NUMBER PRIMARY KEY,
	ID VARCHAR2(20) NOT NULL,
	PASS VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(30) NOT NULL,
	AGE NUMBER(4),
	EMAIL VARCHAR2(30) NOT NULL,
	PHONE VARCHAR2(30) NOT NULL
);

-- 시퀀스 생성
CREATE SEQUENCE TBL_MEMBER_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999999 CYCLE NOCACHE;

-- 조회
SELECT * FROM TBL_MEMBER;

-- 추가
INSERT INTO TBL_MEMBER(NUM, ID, PASS, NAME, AGE, EMAIL, PHONE)
VALUES(TBL_MEMBER_SEQ.NEXTVAL, 'admin', 'admin', '관리자', 40, 'abc@abc.xyz','010-1111-2313');

-- 수정
UPDATE TBL_MEMBER SET AGE=35, PHONE='010-3222-1333' WHERE ID='admin';

--삭제
DELETE FROM TBL_MEMBER WHERE ID='admin'