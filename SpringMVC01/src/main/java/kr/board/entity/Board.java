package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data  // getter setter
@AllArgsConstructor  // 생성자
@NoArgsConstructor  // 기본생성자
@ToString  // 문자열 출력
public class Board {

	private int idx; // 번호
	private String title; // 제목
	private String contents; // 내용
	private String writer; // 작성자
	private String indate; // 작성일
	private int count; // 조회수
	
	

	
	
}
