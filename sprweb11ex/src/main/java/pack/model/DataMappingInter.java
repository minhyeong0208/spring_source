package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInter {
	@Select("select jikwon_no,jikwon_name,jikwon_gen,jikwon_pay from jikwon where jikwon_jik=#{jik} ")
	List<JikwonDto> selectPart(String jik);
}