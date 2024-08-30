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
	
	// 게시글 수정 기능
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) {
		System.out.println("게시글 수정 기능");
		mapper.boardUpdate(vo);
		return "redirect:/boardContents.do?idx="+vo.getIdx();
	}
	
	// 게시글 수정 화면 이동
	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 수정 화면 이동");
		Board vo = mapper.boardContents(idx);       
		model.addAttribute("vo", vo);
		return "boardUpdateForm";
	}
	
	// 게시글 삭제 기능
	@RequestMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx") int idx) {
		System.out.println("게시글 삭제 기능");
		mapper.boardDelete(idx);
	    return "redirect:/boardList.do";
	}
	
	// 게시글 상세보기 기능
	@RequestMapping("/boardContents.do")
	public String boardContents(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 상세보기 기능");
		Board vo = mapper.boardContents(idx);
		model.addAttribute("vo", vo);
		mapper.boardCount(idx);
		return "boardContents";
	}
	
//	// 게시글 입력 기능
//	@RequestMapping("/boardInsert.do")
//	public String boardInsert(Board vo) {
//		System.out.println("게시글 입력 기능");
//		System.out.println(vo.toString());
//		System.out.println(vo.getTitle().isEmpty());
//		
//		if (vo.getTitle().isEmpty() || vo.getContents().isEmpty() || vo.getWriter().isEmpty()) {
//			return "redirect:/boardInsert.do";
//		} else {
//			mapper.boardInsert(vo);
//			return "redirect:/boardList.do";
//		}
//		
//	}
	// 게시글 입력 기능
	@RequestMapping("/boardInsert.do")
	public String boardInsert(Board vo, Model model) {
	    System.out.println("게시글 입력 기능");

	    // 입력된 필드의 공백을 제거한 후 빈 문자열인지 확인하여 null로 변환
	    if (vo.getTitle() != null && vo.getTitle().trim().isEmpty()) {
	        vo.setTitle(null);
	    }
	    if (vo.getContents() != null && vo.getContents().trim().isEmpty()) {
	        vo.setContents(null);
	    }
	    if (vo.getWriter() != null && vo.getWriter().trim().isEmpty()) {
	        vo.setWriter(null);
	    }

	    // 유효성 검사: 제목, 내용, 작성자가 null인지 확인
	    if (vo.getTitle() == null || vo.getContents() == null || vo.getWriter() == null) {
	        // 경고 메시지를 모델에 추가
	        model.addAttribute("errorMessage", "모든 필드를 입력해주세요.");
	        
	        // 사용자가 입력했던 데이터를 모델에 추가하여 다시 폼에 표시
	        model.addAttribute("board", vo);

	        // 입력 폼으로 다시 돌아가기
	        return "boardForm"; // 입력 폼의 JSP 페이지로 이동
	    }

	    // 유효성 검사를 통과하면 게시글을 등록
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
