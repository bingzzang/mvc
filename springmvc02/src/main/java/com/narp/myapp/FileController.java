package com.narp.myapp;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest, HttpServletRequest request) {
		// MultipartHttpServletRequest : 스프링에서 제공하는 파일 업로드시 사용하는 클래스, 첨부파일이 있는경우

		// id, name
		Map map = new HashMap(); // (key, value)
//		String id = multipartRequest.getParameter("id");
//		String name = multipartRequest.getParameter("name");

		// 나열, 열거형
		Enumeration<String> e = multipartRequest.getParameterNames(); // id, name, [file, file2]

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = multipartRequest.getParameter(name);
//			System.out.println(name + ":" + value);

			map.put(name, value);
		}

		// 파일을 담고있는 파라메터 읽어오기
		Iterator<String> it = multipartRequest.getFileNames(); // 파일이름 x, 파라메터이름(file1, file2)..

		while (it.hasNext()) {
			String paramFileName = it.next();
			MultipartFile mFile = multipartRequest.getFile(paramFileName); // 파일(이름, 타입, 크기.. )
			String oName = mFile.getOriginalFilename(); // 실제 업로드된 파일이름
		}
		return "";
	}
}
