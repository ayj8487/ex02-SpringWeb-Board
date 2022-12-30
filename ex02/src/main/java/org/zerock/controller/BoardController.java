package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 컨트롤러 어노테이션으로 스프링 빈 임을 인식                                                                                                                                                                                                                                                                                                                                                                 
@RequestMapping("/board/*") // "/board/" 로 시작하는 모든 처리를 BoardController 가 하도록 지정
@AllArgsConstructor
@Log4j
/*
'/board/list' 를 실행시 BoardController는 Model을 이용해서 게시물의 목록을 'list'라는 이름으로 담아서
전달했으므로 list.jsp에서는 이를 출력한다. list.jsp의 출력은 JSTL 을 이용한다.
*/
public class BoardController {
	// BoardController는 BoardService 에 의존적이므로 @AllArgsConstructor를 이용해서 생성자 자동주입
	// 만약 생성자를 만들지 않을 경우 @Setter(onMethod_ = @Autowired) 처리

	private BoardService service; //BoardService 타입의 객체와 같이 연동

	
	// 게시물 전체 목록
	// list는 나중에 게시물목록을 전달해야 하므로 Model을 파라미터로 지정 하고 이를통해 BoardServiceImpl 객체의 getList() 결과를 담아 전달(addAttribute) 함
	@GetMapping("/list")
	public void list (Model model) { 
		log.info("list");
		
		model.addAttribute("list", service.getList());
	}
	// 게시물 등록
	//String  타입으로 지정하고 RedirectAttributes 를 파라미터로 지정
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("regist : " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list"; //redirect: 접두어 사용시 내부적으로 response.secdRedirect() 처리
	}
	// 게시물 조회
	//bno 값을 더 명시적으로 처리하기위해 @RequestParam사용, 화면쪽으로 해당 번호의 게시물을 전달해야하므로 Model파라미터 지정
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) { 
		log.info("/get");
		model.addAttribute("board",service.get(bno));
	}
	// 게시물 수정
	// 변경된 내용을 수집하여 BoardVO 파라미터로 처리하고 BoardService를 호출
	// 수정 작업을 시작하는 화면의 경우 GET방식이지만 실제 작업은 POST이기에 POSTMapping사용
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify :" + board);
		
		//수정 여부를 boolean으로 처리하므로 이를 성공한경우에만 RedirectAttributes에 추가
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	// 게시물 삭제
	// 삭제는 반드시 post 방식으로만 처리,
	// remove()메서드로 삭제 시킨 후 이동할 페이지가 필요하기에 RedirectAttributes 파라미터 사용
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove :" + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	// 작성 페이지 이동
	@GetMapping("/register")
	public void register() {
	}
}
