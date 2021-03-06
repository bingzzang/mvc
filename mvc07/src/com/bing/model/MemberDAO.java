package com.bing.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	private static SqlSessionFactory sqlSessionFactory;

	// 초기화 블럭 - 프로그램 실행시 딱 한번만 실행되는 코드영역
	static {
		try {
			String resource = "com/bing/mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 회원 전체 리스트 보기
	public List<MemberVO> memberList() {

		// [Connection + Statement(전송객체)] => SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> list = session.selectList("memberList");
		session.close(); // 반납

		return list;

	}

	// 회원 가입
	public int memberInsert(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
//		session.insert("sql_id", vo);
		int cnt = session.insert("memberInsert", vo);
		session.commit();
		session.close();

		return cnt;
	}

	// 회원가입 파일 업로드
	public int memberInsertFile(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("memberInsertFile", vo);
		session.commit();
		session.close();

		return cnt;
	}

	// 회원 삭제
	public int memberDelete(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("memberDelete", num);
		session.commit();
		session.close();

		return cnt;
	}

	// 회원 상세
	public MemberVO getMemberContent(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo = session.selectOne("memberContent", num);

		return vo;
	}

	// 회원 수정
	public int updateMember(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("memberUpdate", vo);
		session.commit();
		session.close();
		return cnt;
	}

	public int memberUpdateFile(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("memberUpdateFile", vo);
		session.commit();
		session.close();
		return cnt;
	}

	// 회원 로그인
	public String memberLogin(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		String user_name = session.selectOne("memberLogin", vo);
		session.close();
		return user_name;
	}

	// 중복 확인
	public String memberDbcheck(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		String dbId = session.selectOne("memberDbcheck", id);// id or null
		String idDouble = "NO";

		if (dbId != null) {
			idDouble = "YES";
		}

		return idDouble; // YSE(중복), ON(중복아님)
	}

	// 파일 삭제
	public int memberDeleteFile(int num) {

		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("memberDeletefile", num);
		session.commit();
		session.close();
		return cnt;
	}

}
