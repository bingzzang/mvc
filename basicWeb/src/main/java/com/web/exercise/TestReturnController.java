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

	@GetMapping("/test/return/reList")
	@ResponseBody
	public ResponseEntity<List<String>> listStrRe() {
		ResponseEntity<List<String>> list = null;

		List<String> strList = new ArrayList<String>();
		strList.add("네이버");
		strList.add("카카오");
		strList.add("라인");
		strList.add("쿠팡");
		strList.add("배달의민족");

		list = new ResponseEntity<List<String>>(strList, HttpStatus.OK);

		return list;
	}

	@GetMapping("/test/return/reListMap")
	@ResponseBody
	public ResponseEntity<List<Map<String, Object>>> listMapRE() {

		ResponseEntity<List<Map<String, Object>>> resultEntity = null;

		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> inMap = new HashMap<String, Object>();

		inMap.put("삼성", "전자");
		inMap.put("삼성", "건설");
		inMap.put("삼성", "금융");
		inMap.put("삼성", "조선");

		resultList.add(inMap);

		inMap = new HashMap<String, Object>();
		inMap.put("네이버", "포털");
		inMap.put("네이버", "라인");
		inMap.put("네이버", "이커머스");

		resultList.add(inMap);

		inMap = new HashMap<String, Object>();
		inMap.put("카카오", "메신저");
		inMap.put("카카오", "은행");
		inMap.put("카카오", "O2O");

		resultList.add(inMap);

		resultEntity = new ResponseEntity<List<Map<String, Object>>>(resultList, HttpStatus.OK);

		return resultEntity;
	}
}
