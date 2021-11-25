package com.bing.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	// data access object
	// jdbc -> mybatis, jpa

	private Connection conn; // 데이터베이스 연결에 가장 기본적인 객체
	private PreparedStatement ps; // sql 전송할 수 있는 객체
	private ResultSet rs; // 데이터베이스에 있는 데이터를 가져와서 저장하는 객체

}
