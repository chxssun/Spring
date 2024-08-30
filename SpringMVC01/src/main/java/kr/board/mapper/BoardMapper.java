package kr.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper // Mapper로 인식하기 위한 어노테이션
public interface BoardMapper {

//	@Select("SELECT * FROM BOARD ORDER BY INDATE DESC")
	public ArrayList<Board> boardList();

	public void boardInsert(Board vo);

	public Board boardContents(int idx);

	public void boardDelete(int idx);

	public void boardCount(int idx);

	public void boardUpdate(Board vo);



	
	
}



//-----------------------------------------------------
// 스프링 실행시 밑에 클래스가 자동 생성되게해서 위의 코드가 작동됨
//public class SqlSessionFactoryBean implements BoardMapper{
//
//	@Override
//	public ArrayList<Board> boardList() {
//		// JDBC 코드 구현
//		return null;
//	}
//	
//}








