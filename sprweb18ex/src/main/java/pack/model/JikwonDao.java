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
	public DataRepository repository;
	
	public List<Jikwon> selectAll(String buser_num) {
		List<Jikwon> slist = repository.searchAll(buser_num);
		return slist;
	}
	
	public List<Jikwon> select(String buser_num, String jikwon_rating) {
		List<Jikwon> slist = repository.search(buser_num, jikwon_rating);
		return slist;
	}
}
