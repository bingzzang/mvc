package com.narp.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

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
}
