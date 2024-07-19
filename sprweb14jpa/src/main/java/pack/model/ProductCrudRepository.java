package pack.model;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer> {
	// CrudRepository > PagingAndSortingRepository > JpaRepository
	// JpaRepository는 CrudRepository, PagingAndSortingRepository에 구현된 기능을 모두 가지고 있다.
	
	// JPA 쿼리 메소드 사용(메소드 이름으로 쿼리 생성 방법 : find + (엔티티 이름) + By + (변수 이름))
	// 엔티티 이름은 생략 가능
	ProductVo findByCode(Integer code);
	
	// JPQL
	@Query(value = "select p from ProductVo as p")  // 물리적인 이름 product를 쓰면 안됨.
	List<ProductVo> findAllData();
	
	// where 조건 : 이름 기반
	@Query(value = "select p from ProductVo as p where p.code=:code")
	ProductVo findByCodeMy(@Param("code") int code);
	
	// where 조건 : 순서 기반
	@Query(value = "select p from ProductVo as p where p.code=?1")
	ProductVo findByCodeMy2(int code);
	
	@Query(value = "select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVo> findByData(int code, String sang);
	
	// Native Query문 사용
	@Query(value = "select code, sang, su, dan from product where code <=5", nativeQuery = true)  // product는 물리적인 테이블명
	List<ProductVo> findAllData2();
}