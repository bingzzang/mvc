package com.bing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		} finally {
			dbclose();
		}

		return cnt;
	}

	// 회원 전체 리스트 가져오기
	public List<MemberVO> getMemberList() {
		String sql = "select * from tbl_member order by num";
		getConnect();

		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				// 묶고 -> 담고
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int memberDelete(int num) {
		String sql = "delete from tbl_member where num=?";
		getConnect();
		int cnt = -1;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dbclose();
		}

		return cnt;
	}

	public MemberVO getMemberContent(int num) {
		String sql = "select * from tbl_member where num=?";

		getConnect();
		MemberVO vo = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				// 회원한명의 정보를 가져와서 -> 묶음(VO)
				num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				vo = new MemberVO(num, id, pass, name, age, email, phone);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}

		return vo;
	}

	public int updateMember(MemberVO vo) {

		String sql = "update tbl_member set age=?, email=?, phone=? where num=?";
		getConnect();

		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());

			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}

		return cnt;
	}

	// 데이터베이스 연결 끊기
	public void dbclose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
