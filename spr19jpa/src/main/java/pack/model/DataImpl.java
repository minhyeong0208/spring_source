package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {
	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");  // DB 연결 정보 : 인수 값은 persistence.xml의 <persistence-unit name="hello"> name 속성에 해당
		EntityManager em = emf.createEntityManager();  // 엔티티의 생명주기를 관리. CRUD를 수행한다.
		EntityTransaction tx = em.getTransaction();    // 트랜잭션(Transaction)을 관리하는 인터페이스 , commit, rollback 등을 수행한다.
		
		List<MemDto> list = null;

		// 자료 읽기
		System.out.println("전체 자료 읽기");
		list = findAll(em, MemDto.class); // 두 번째 인자로 엔티티 클래스 전달한다.
		
		for(MemDto m : list) {
			System.out.println(m.getNumber() + " " + m.getName() + " " + m.getAddr());
		}
		
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla) {
		// select 문의 경우, SQL문이 아닌 JPQL임.
		System.out.println(cla.getSimpleName());
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();  // 테이블에 대한 별명을 'e'로 설정
	}
}
