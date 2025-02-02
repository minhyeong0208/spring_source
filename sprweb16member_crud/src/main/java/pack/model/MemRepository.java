package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemRepository extends JpaRepository<Mem, Integer>{
	// num 자동 증가용
	@Query(value = "select max(m.num) from Mem as m")  // JPQL 사용
	//@Query(value = "select max(num) from mem", nativeQuery = true)  // Native Query 사용
	int findByMaxNum();
	
	@Query("select m from Mem as m where m.num=:num1")
	Mem findByNum(@Param("num1") String num);
	
//	@Query("select m from Mem as m where m.num=?1")
//	Mem findByNum(String num);
}