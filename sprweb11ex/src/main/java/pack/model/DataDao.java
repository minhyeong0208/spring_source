package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao { 
	
	@Autowired
	private DataMappingInter mappingInter;

	// 데이터 검색
	public List<JikwonDto> getDataSearch(String jik) {
		List<JikwonDto> list = mappingInter.selectPart(jik);
		return list;
	}
}
