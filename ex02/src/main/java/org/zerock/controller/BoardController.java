package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 컨트롤러 어노테이션으로 스프링 빈 임을 인식                                                                                                                                                                                                                                                                                                                                                                 
@RequestMapping("/board/*") // "/board/" 로 시작하는 모든 처리를 BoardController 가 하도록 지정
@AllArgsConstructor
@Log4j
public class BoardController {
	// BoardController는 BoardService 에 의존적이므로 @AllArgsConstructor를 이용해서 생성자 자동주입
	// 만약 생성자를 만들지 않을 경우 @Setter(onMethod_ = @Autowired) 처리

	private BoardService service; //BoardService 타입의 객체와 같이 연동

	
	//게시물 전체 목록
	// list는 나중에 게시물목록을 전달해야 하므로 Model을 파라미터로 지정 하고 이를통해 BoardServiceImpl 객체의 getList() 결과를 담아 전달(addAttribute) 함
	@GetMapping("/list")
	public void list (Model model) { 
		log.info("list");
		
		model.addAttribute("list", service.getList());
	}
}
