package kr.board.entity;

public class Board {

	private int idx; // 번호
	private String title; // 제목
	private String contents; // 내용
	private String writer; // 작성자
	private String indata; // 작성일
	private int count; // 조회수
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIndata() {
		return indata;
	}
	public void setIndata(String indata) {
		this.indata = indata;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
