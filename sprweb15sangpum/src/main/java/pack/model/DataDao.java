package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	private SangpumRepository repository;
	
	// 전체 자료 읽기
	public List<Sangpum> getDataAll() {
		List<Sangpum> list = repository.findAll();  // JPA가 제공하는 기본 메소드
		return list;
	}
	
	// 검색 자료 읽기
	public List<Sangpum> getDataSearch(String svalue) {
		//List<Sangpum> list = repository.findBySangContaining(svalue); // 메소드 네이밍 사용
		List<Sangpum> list = repository.searchLike(svalue);  // JPQL 사용
		System.out.println("list : " + list.size());
		return list;
	}
}
