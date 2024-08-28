package kr.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.board.entity.Board;

@Mapper // Mapper로 인식하기 위한 어노테이션
public interface BoardMapper {

	@Select("SELECT * FROM BOARD")
	public ArrayList<Board> boardList(); 
	
	
}
