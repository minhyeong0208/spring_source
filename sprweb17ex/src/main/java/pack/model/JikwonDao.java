package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.JikwonBean;

@Repository
public class JikwonDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public DataMapInterface mapInterface;
	
	// 검색
	public List<Jikwon> search(String buser_num, String jikwon_rating) {
		List<Jikwon> slist = mapInterface.selectSearch(buser_num, jikwon_rating);
		return slist;
	}
}
