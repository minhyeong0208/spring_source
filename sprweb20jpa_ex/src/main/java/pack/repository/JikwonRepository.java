package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	Jikwon findByJno(int jno);
}
