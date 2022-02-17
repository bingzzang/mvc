package com.web.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.exercise.test.vo.TestReturnBoardVo;

//@Controller
@RestController
public class TestReturnController {

	private static final Logger logger = LoggerFactory.getLogger(TestReturnController.class);

	@GetMapping("/test/return/list")
	public String list() {

		return "test/return/testReturnList";
	}

	@GetMapping("/test/return/voList")
//	@ResponseBody
	public TestReturnBoardVo listVo() {
		TestReturnBoardVo testReturnBoardVo = new TestReturnBoardVo();
		testReturnBoardVo.setBoardId("20220217001");
		testReturnBoardVo.setBoardTitle("테스트 제목");
		testReturnBoardVo.setBoardContent("테스트 글 내용이다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
		testReturnBoardVo.setBoardWriter("홍길동");

		return testReturnBoardVo;
	}

	@GetMapping("/test/return/strList")
	@ResponseBody
	public List<String> strList() {
		List<String> resultList = new ArrayList<String>();

		resultList.add("자수정");
		resultList.add("가넷");
		resultList.add("아쿠아마린");
		resultList.add("다이아몬드");
		resultList.add("에메랄드");
		resultList.add("사파이어");

		return resultList;
	}

	@GetMapping("/test/return/strMap")
	@ResponseBody
	public Map<String, Object> strMap() {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("January", "가넷");
		resultMap.put("February", "자수정");
		resultMap.put("March", "아쿠아마린");

		return resultMap;
	}

	@GetMapping("/test/return/reString")
	@ResponseBody
	public ResponseEntity<String> strRe() {
		ResponseEntity<String> re = new ResponseEntity<String>("Good day", HttpStatus.OK);

		return re;
	}

}
