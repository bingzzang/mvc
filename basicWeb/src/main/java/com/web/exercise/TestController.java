package com.web.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.exercise.test.vo.TestBoardVo;

@Controller
@RequestMapping("/test")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/list")
	public String testList() {
		logger.info("TestController, testList.");

		return "test/testList";
	}

	@GetMapping("/detail")
	public String testDetail(Model model) {
		logger.info("TestController, testDetail");

		return "test/testDetail";
	}

	@PostMapping("/detail/post")
	public ResponseEntity<String> testDetailPost(@RequestBody TestBoardVo testBoardVo) {
		logger.info("TestController, testDetailPost");

		if (testBoardVo != null) {
			logger.info(testBoardVo.toString());
		}

		ResponseEntity<String> resultEntity = null;

		try {
			resultEntity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			resultEntity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return resultEntity;

	}

	@PutMapping("/detail/put")
	public ResponseEntity<String> testDetailPut(@RequestBody TestBoardVo testBoardVo) {
		logger.info("TestController, testDetailPut");

		if (testBoardVo != null) {
			logger.info(testBoardVo.toString());
		}

		ResponseEntity<String> resultEntity = null;

		try {
			resultEntity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			resultEntity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return resultEntity;

	}

	@PostMapping("/detail/xml")
	public ResponseEntity<String> testDetailXml(@RequestBody TestBoardVo testBoardVo) {
		logger.info("TestController, testDetailXml");

		if (testBoardVo != null) {
			logger.info(testBoardVo.toString());
		}

		ResponseEntity<String> resultEntity = null;

		try {
			resultEntity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			resultEntity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return resultEntity;

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String testInsert() {
		logger.info("TestController, testInsert");

		return "test/testInsert";
	}

	@PostMapping(value = "/update")
	public String testUpdate() {
		logger.info("TestController, testUpdate");

		return "test/testUpdate";
	}

	@PostMapping(value = "/delete")
	public String testDelete() {
		logger.info("TestController, testDelete");

		return "test/testDelete";
	}
}
