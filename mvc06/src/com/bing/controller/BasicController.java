package com.bing.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BasicController {

	// 모든 POJO가 가지고 있어야 하는 메서드
	// ? -> String(다음페이지 정보)
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
