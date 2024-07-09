package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
	
	@Override
	public List<CountPartDto> countPart() {
		SqlSession sqlSession = factory.openSession();
		List<CountPartDto> list2 = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list2 = mapperInter.countPart();
		} catch (Exception e) {
			System.out.println("countPart err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list2;
	}
	
	@Override
	public List<JikwonDto> maxPay() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list3 = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list3 = mapperInter.maxPay();
		} catch (Exception e) {
			System.out.println("maxPay err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list3;
	}
}
