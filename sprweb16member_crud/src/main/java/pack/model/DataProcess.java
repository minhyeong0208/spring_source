package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	
	@Autowired
	private MemRepository repository;
	
	// 전체 자료 읽기
	public List<Mem> getDataAll() {
		List<Mem> list = repository.findAll();
		return list;
	}
	
	// 추가
	public String insert(MemBean bean) {
		// num 자동 증가
		// int max = repository.findByMaxNum();
		
		// num 중복 확인
		try {
			Mem mem = repository.findById(bean.getNum()).get(); // 해당 번호 읽기
			System.out.println("mem : " + mem);
			return "이미 등록된 번호입니다.";
		} catch (Exception e) {
			try {
				// 등록되지 않은 번호인 경우, 데이터 추가
				// 중복 검사 안하는 경우 이것만 작성하면 된다.
				Mem mem = new Mem();
				mem.setNum(bean.getNum());
				mem.setName(bean.getName());
				mem.setAddr(bean.getAddr());
				mem = repository.save(mem);
				System.out.println("mem : " + mem);
				return "등록 완료";
			} catch (Exception e2) { 
				return "입력 오류 : " + e2.getMessage();
			}
		}
	}
	// 수정
	
	// 삭제
}