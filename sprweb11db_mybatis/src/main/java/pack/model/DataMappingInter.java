package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMappingInter {
	
	@Select("select code,sang,su,dan from sangdata")
	List<SangpumDto> selectAll();
	
	// MySQL, MariaDB
	@Select("select code,sang,su,dan from sangdata where sang like concat('%',#{searchValue},'%')")
	// Oracle -> concat (x)
	// @Select("select code,sang,su,dan from sangdata where sang like '%'||#{serachValue}||'%'")
	List<SangpumDto> selectSearch(FormBean bean);
	
	// 데이터 하나 추출
	@Select("select code,sang,su,dan from sangdata where code=#{code}")
	SangpumDto selectData(String code);
}
