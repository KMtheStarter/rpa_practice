package kr.co.newscrawling.AA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/board")
	public String board(Model model) {
		List<BoardVO> list = service.selectAllBoard();
		model.addAttribute("boardList", list);
		return "board";
	}
	
	@GetMapping("/board/{num}")
	public String detail(@PathVariable("num") int num, Model model) {
		BoardVO vo = service.detailBoard(num);
		model.addAttribute("board", vo);
		return "detail";
	}
	
	@PostMapping("/board/{num}")
	public String modify(@PathVariable("num") int num, BoardVO vo) {
		vo.setNum(num);
		service.modifyBoard(vo);
		return "redirect:/board";
	}
	
	@ResponseBody
	@DeleteMapping("/board/{num}")
	public int delete(@PathVariable("num") int num) {
		return service.deleteBoard(num);
	}
	
	@GetMapping("/post")
	public String post() {
		return "post";
	}
	
	@PostMapping("/post")
	public String write(BoardVO vo) {
		service.insertBoard(vo);
		return "redirect:/board";
	}
	
	@GetMapping("/modify/{num}")
	public ModelAndView modPage(@PathVariable("num") int num, ModelAndView mav) {
		BoardVO vo = service.detailBoard(num);
		mav.addObject("board", vo);
		mav.setViewName("modify");
		return mav;
	}
}
