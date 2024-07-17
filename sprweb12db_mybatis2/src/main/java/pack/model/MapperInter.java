package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.MemberBean;

@Mapper  // 마커 인터페이스
public interface MapperInter {
	
	@Select("SELECT * FROM mem")
	List<MemberDto> selectAll();
	
	@Select("SELECT * FROM mem WHERE num=#{num}")
	List<MemberDto> selectPart(String num);
	
	@Insert("INSERT into mem values(#{num},#{name},#{addr}")
	int insertData(MemberBean bean);
	
	@Update("UPDATE mem set name=#{name},addr=#{addr} WHERE num=#{num}")
	int updateData(MemberBean bean);
	
	@Delete("DELETE FROM mem WHERE num=#{num}")
	int deleteData(String num);
}
