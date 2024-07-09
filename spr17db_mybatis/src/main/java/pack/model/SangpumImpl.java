package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<SangpumDto> selectDataAll() {
		// SqlSession : 명령어를 실행하고 매퍼를 얻으며 트랜잭션 관리를 위한 인터페이스이다.
		// SqlSession 인스턴스는 SqlSessionFactory 인스턴스를 사용해서 만든다.
		
		SqlSession session = factory.openSession();
		List<SangpumDto> list = null;
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}
}
