package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Controller가 되기위해 어노테이션으로 명시
public class BoardController {

	// 게시판 전체조회 기능 - boardList.do
	@RequestMapping("/boardList.do") // 아래 메소드와 url을 연결
	public String boardList() {
		System.out.println("게시판 전체조회 기능");
		
		// 게시판 정보 가져오기
		// 게시글 - 번호, 제목, 내용, 작성자, 작성일, 조회수
		
		
		return "boardList"; // WEB-INF/views/boardList.jsp
	}
	
}
