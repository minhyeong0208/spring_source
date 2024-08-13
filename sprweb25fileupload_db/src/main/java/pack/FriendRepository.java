package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FriendRepository extends JpaRepository<Friend, Integer>{
	
	// 최대 bunho 값 구하는 JPQL
	@Query("select max(f.bunho) from Friend f")
	Integer findLastBunho();
	
	
}
