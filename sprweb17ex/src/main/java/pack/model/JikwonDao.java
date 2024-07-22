package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.JikwonBean;

@Repository
public class JikwonDao {
	
	@Autowired
	public DataMapInterface mapInterface;
	
	public List<Jikwon> selectAll() {
		List<Jikwon> slist = mapInterface.selectList();
		return slist;
	}
	
	// 검색
	public List<Jikwon> search(JikwonBean bean) {
		List<Jikwon> slist = mapInterface.selectSearch(bean);
		return slist;
	}
}
