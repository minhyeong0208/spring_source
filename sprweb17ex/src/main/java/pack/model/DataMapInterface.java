package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.JikwonBean;

@Mapper
public interface DataMapInterface {

	List<Jikwon> selectSearch(String buser_num, String jikwon_rating);
	
}
