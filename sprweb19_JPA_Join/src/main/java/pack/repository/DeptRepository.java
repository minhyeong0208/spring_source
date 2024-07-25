package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.entity.Dept;

//int <- 0
//Integer <- Null // 참조형 인스턴스 안하면 Null임
public interface DeptRepository extends JpaRepository<Dept, Integer>{

}
