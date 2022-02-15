package com.web.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * freeBoard
 * 
 * @author bing
 */
@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);

	/**
	 * freeBoard List
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String freeboardList() {
		return "freeBoardList";
	}

	/**
	 * freeBoard Insert
	 * 
	 * @return
	 */
	@GetMapping(value = "/insert")
	public String freeboardInsert() {
		return "freeBoardInsert";
	}

	/**
	 * freeBoard Modify
	 * 
	 * @return
	 */
	@GetMapping(value = "/modify")
	public String freeboardModify() {

		return "freeBoardModify";
	}
}
