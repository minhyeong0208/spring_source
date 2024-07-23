package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<Jikwon, Integer> {
	// 부서별 JPQL
	@Query("select j from Jikwon as j where j.buser=?1") 
	List<Jikwon> searchAll(String buser);  
	
	@Query("select j from Jikwon j where j.buser=?1 and j.rating=?2")
	List<Jikwon> search(String buser, String rating); 
	
}
