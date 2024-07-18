package pack;

import org.springframework.data.repository.CrudRepository;

// CrudRepository<엔티티클래스, 주키타입(wrapper class)>가 제공하는 메소드 사용 가능.
// save(), findById(), count() 등의 메소드를 지원함.
public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer>{
	
}