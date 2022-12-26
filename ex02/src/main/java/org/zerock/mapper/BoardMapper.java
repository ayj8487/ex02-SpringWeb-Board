package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	// 간단한 SQL쿼리라면 @어노테이션으로 처리할 수 있지만
	// 복잡한 쿼리나 상황에 따라다른 SQL 쿼리를 사용하려면 MyBatis를 활용해 XML로 대체 한다 
//	@Select("select * from tbl_board where bno > 0")

	public List<BoardVO> getList();
	
}