package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pack.controller.FormBean;

@Repository
@Slf4j // lombok이 지원하는 로그 출력 어노테이션
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());  // this.getClass() : DataDao.class
	
	@Autowired
	private DataMappingInter mappingInter;

	public List<SangpumDto> getDataAll() {
		List<SangpumDto> list = mappingInter.selectAll();
		
		// 로그 출력 : console
		System.out.println("list.size : " + list.size());
		// 로그 출력 : logger
		logger.info("list.size : " + list.size());
		
		return list;
	}
	
	// 데이터 검색
	public List<SangpumDto> getDataSearch(FormBean bean) {
		List<SangpumDto> slist = mappingInter.selectSearch(bean);
		return slist;
	}
	
	// 데이터 하나 추출
	public SangpumDto getData(String id) {
		SangpumDto dto = mappingInter.selectData(id);
		
		return dto;
	}
}
