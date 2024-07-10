package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInter{
	
	@Override
	public List<JikwonDto> selectAllJikwon() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		List<JikwonDto> list = em.createQuery("select j from JikwonDto as j", JikwonDto.class).getResultList();
		
		em.close();
		emf.close();
		return list;
	}
	
	@Override
	public List<Object[]> selectAllBuser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		// 2개의 인덱스(부서번호, 직원 수)를 갖는 🌟배열🌟을 담은 List
		List<Object[]> result = em.createQuery("select j.buser_num, count(j.jikwon_no) FROM JikwonDto as j group by j.buser_num", Object[].class).getResultList();
		
		em.close();
		emf.close();
		return result;
	}
}
