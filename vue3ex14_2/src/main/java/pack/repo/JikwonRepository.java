package pack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	List<Jikwon> findByJik(String jik);
}
