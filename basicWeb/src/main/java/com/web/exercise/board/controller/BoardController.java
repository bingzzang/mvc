package com.web.exercise.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.exercise.board.service.BoardService;
import com.web.exercise.board.vo.BoardVO;

/**
 * 게시판
 * 
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	/**
	 * 저장 화면 이동
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/board/register")
	public String boardRegister(Model model) throws Exception {

		logger.info("BoardController, boardRegister.");

		return "board/register";
	}

	/**
	 * 저장 동작
	 * 
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/board/register")
	public String boardRegisterPost(BoardVO boardVO) throws Exception {

		logger.info("BoardController, boardRegisterPost.");
		logger.info("boardVOtoString : {}", boardVO.toString());

		int result = boardService.insertBoard(boardVO);

		logger.info("result : {}", result);

		return "board/result";
	}

	/**
	 * 목록 화면 이동
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardList(Model model) throws Exception {

		logger.info("BoardController, boardList.");

		List<BoardVO> resultList = boardService.selectBoardList();
		logger.info("resultList : {}", resultList.toString());

		model.addAttribute("resultList", resultList);

		return "board/list";
	}

	/**
	 * 게시판 상세
	 * 
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/board/detail")
	public String boardDetail(Model model, BoardVO boardVO) throws Exception {

		logger.info("BoardController, boardList.");

		BoardVO resultData = boardService.selectBoardDetail(boardVO);
		logger.info("resultData : {}", resultData.toString());

		model.addAttribute("resultData", resultData);

		return "board/detail";
	}

	/**
	 * 수정 화면 이동
	 * 
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/board/modify")
	public String boardModify(Model model, BoardVO boardVO) throws Exception {

		logger.info("BoardController, boardList.");

		BoardVO resultData = boardService.selectBoardDetail(boardVO);
		logger.info("resultData : {}", resultData.toString());

		model.addAttribute("resultData", resultData);

		return "board/modify";
	}

	/**
	 * 수정 동작
	 * 
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/board/modify")
	public String boardModifyPost(BoardVO boardVO) throws Exception {

		logger.info("BoardController, boardModifyPost.");

		int result = boardService.updateBoard(boardVO);
		logger.info("result : {}", result);

		return "board/result";
	}

	/**
	 * 삭제 동작
	 * 
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/board/delete")
	public String boardDeletePost(BoardVO boardVO) throws Exception {

		logger.info("BoardController, boardDeletePost.");

		int result = boardService.deleteBoard(boardVO);
		logger.info("result : {}", result);

		return "board/result";
	}

}
