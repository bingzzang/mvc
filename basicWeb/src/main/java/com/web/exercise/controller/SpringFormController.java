package com.web.exercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.exercise.test.vo.OrderRequest;

/**
 * 스프링 폼 태그
 */
@Controller
public class SpringFormController {

	private static final Logger logger = LoggerFactory.getLogger(SpringFormController.class);

	/**
	 * 스프링폼 등록 화면
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/springform/registerForm")
	public String registerForm(Model model) throws Exception {

		logger.info("SpringFormController, registerForm.");

		model.addAttribute("orderRequest", new OrderRequest());

		return "springform/registerForm";
	}

	/**
	 * 스프링폼 데이터 전달
	 * 
	 * @param orderRequest
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/springform/register")
	public String springFormRegisterPost(OrderRequest orderRequest) throws Exception {

		logger.info("SpringFormController, springFormRegisterPost.");

		logger.info("데이터 확인 : {}", orderRequest.getOrderRequestNo());
		logger.info("데이터 확인 : {}", orderRequest.getOrderRequestDate());
		logger.info("데이터 확인 : {}", orderRequest.getItemNm());

		return "springform/result";
	}

}
