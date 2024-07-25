package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>{
	// 기본형 : 기본값 int <- 0
	// 참조형 : 기본값 Integer <- null
	
}
