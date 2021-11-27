package com.bing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	// data access object
	// jdbc -> mybatis, jpa

	private Connection conn; // 데이터베이스 연결에 가장 기본적인 객체
	private PreparedStatement ps; // sql 전송할 수 있는 객체
	private ResultSet rs; // 데이터베이스에 있는 데이터를 가져와서 저장하는 객체

	// 데이터베이스 연결객체 생성
	public void getConnect() {
		// 데이터베이서 접속 url, user, password
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:java";
		String user = "bing";
		String password = "bing930303";

		// Oracle Driver Loading
		try {
			// 동적로딩(실행지점에서 객체를 생성하는 방법)
			Class.forName("oracle.jdbc.OracleDriver"); // 동적로딩, 실행시점에 메모리에 올림
			conn = DriverManager.getConnection(url, user, password); // 실패하면 예외발생
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원저장 동작
	public int memberInsert(MemberVO vo) {
		String sql = "insert into tbl_member(num, id, pass, name, age, email, phone) "
				+ "values(TBL_MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		getConnect();

		// sql 문장을 전송하는 객체 생성

		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql); // 먼저 컴파일 시킴 (속도가 빠르기 때문)
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());

			cnt = ps.executeUpdate(); // 전송(실행), 파라미터로 sql 써버리면 ?가 설정안된상태로 넘어가게 되므로 sql을 넣지않음
			// 성공일시 1(row의 수), 실패면 0

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cnt;
	}
}
