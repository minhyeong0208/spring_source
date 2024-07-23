package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DataMapInterface {
	
	List<Jikwon> selectBuserNum(int buserNum);
	List<Jikwon> selectRaiting(@Param("buserNum") int buserNum, @Param("rating") String rating);

}
