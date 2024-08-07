package pack.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.JikwonDto;

@Repository
public class JikwonDao {

	@Autowired
	private SqlSession session;
	
	public List<JikwonDto> getList(String buser_name) {
		return session.selectList("jikwon.getData", buser_name);
	}
}
