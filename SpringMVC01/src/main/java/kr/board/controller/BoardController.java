package kr.board.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller // Controller가 되기위해 어노테이션으로 명시
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	
	// 게시글 삭제 기능
	@RequestMapping("boardDelete.do")
	public String boardDelete(@RequestParam("idx") int idx) {
		System.out.println("게시글 삭제 기능");
		mapper.boardDelete(idx);
	    return "redirect:/boardList.do";
	}
	
	// 게시글 상세보기 기능
	@RequestMapping("boardContents.do")
	public String boardContents(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 상세보기 기능");
		Board vo = mapper.boardContents(idx);
		model.addAttribute("vo", vo);
		mapper.countUpdate(idx);
		return "boardContents";
	}
	
	// 게시글 입력 기능
	@RequestMapping("boardInsert.do")
	public String boardInsert(Board vo) {
		System.out.println("게시글 입력 기능");
		mapper.boardInsert(vo);
		return "redirect:/boardList.do";
	}
	
	// 게시판 입력페이지 이동 기능
	@RequestMapping("/boardForm.do") // 아래 메소드와 url을 연결
	public String boardForm(Model model) {
		System.out.println("게시판 글쓰기 기능");
		// Forward 이동방식
		return "boardForm"; // WEB-INF/views/boardList.jsp
	}
	
	// 게시판 전체조회 기능 - boardList.do
	@RequestMapping("/boardList.do") // 아래 메소드와 url을 연결
	public String boardList(Model model) {
		System.out.println("게시판 전체조회 기능");
		
		ArrayList<Board> list = mapper.boardList();
		
		model.addAttribute("list", list);
		
		// Forward 이동방식
		return "boardList"; // WEB-INF/views/boardList.jsp
		
	}
	
}
