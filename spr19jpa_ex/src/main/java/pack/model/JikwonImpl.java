package pack.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl implements JikwonInter {

	@Override
	public List<JikwonDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();

		List<JikwonDto> list = null;
		try {
			list = em.createQuery("select j from JikwonDto j", JikwonDto.class).getResultList();
		} catch (Exception e) {
			System.out.println("selectDataAll() err : " + e);
		} finally {
			emf.close();
			em.close();
		}
		
		return list;
	}
	
	@Override
	public List<BuserDto> countPart() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();

		List<Object[]> results = null;
		List<BuserDto> list2 = new ArrayList<>();

		try {
			results = em.createQuery("select j.buser_num, count(j) from JikwonDto j group by j.buser_num").getResultList();
			for(Object[] res : results) {
				BuserDto buserDto = new BuserDto();
				buserDto.setBuser_num((String) res[0]);
				buserDto.setCountPart(res[1].toString());
				list2.add(buserDto);
			}
		} catch (Exception e) {
			System.out.println("countPart() err : " + e);
		} finally {
			emf.close();
			em.close();
		}
		return list2;
	}
	
	
}
