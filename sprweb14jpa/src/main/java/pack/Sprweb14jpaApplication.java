package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.ProductCrudRepository;
import pack.model.ProductVo;

@SpringBootApplication
public class Sprweb14jpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb14jpaApplication.class, args)
			.getBean(Sprweb14jpaApplication.class).execute();
	}
	
	@Autowired
	ProductCrudRepository repository;
	
	private void execute() {
		System.out.println("키키");
		
		//insertData();
		//updateData();
		selectData();
	}
	
	private void insertData() {
		ProductVo productVo = new ProductVo();
		productVo.setSang("볼펜");
		productVo.setSu(3);
		productVo.setDan(3000);
		
		productVo = repository.save(productVo);
		System.out.println("등록 데이터 : " + productVo);
	}
	
	private void updateData() {
		ProductVo productVo = new ProductVo();
		productVo.setCode(1);
		productVo.setSang("지우개");
		productVo.setSu(5);
		productVo.setDan(1000);
		
		productVo = repository.save(productVo);
	}
	
	private void selectData() {
		System.out.println("전체 자료 읽기 : JPA는 DBMS에 독립적");
		List<ProductVo> list = repository.findAll();
		
		for(ProductVo vo: list) {
			System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		}
		
		
		System.out.println("------ 부분 자료 읽기 ------");
		ProductVo vo = repository.findById(1).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
		System.out.println("부분 자료 읽기 : JPQL");
		ProductVo vo3 = repository.findByCode(1);  // findByCode() : 규칙에 따라 만든 메소드
		System.out.println(vo3.getCode() + " " + vo3.getSang() + " " + vo3.getSu() + " " + vo3.getDan());
		
		
		System.out.println("------ JPQL 사용 ------");
		List<ProductVo> list2 = repository.findAllData();  // findAllData() 메소드는 직접 만든 메소드
		
		for(ProductVo vo2: list2) {
			System.out.println(vo2.getCode() + " " + vo2.getSang() + " " + vo2.getSu() + " " + vo2.getDan());
		}
		
		System.out.println("부분 자료 읽기 : JPQL");
		ProductVo vo4 = repository.findByCodeMy(1);  // 메소드 이름 임의 생성(이름 기반)
		System.out.println(vo4.getCode() + " " + vo4.getSang() + " " + vo4.getSu() + " " + vo4.getDan());
		
		
		ProductVo vo5 = repository.findByCodeMy2(1);  // 메소드 이름 임의 생성(순서(위치) 기반)
		System.out.println(vo5.getCode() + " " + vo5.getSang() + " " + vo5.getSu() + " " + vo5.getDan());
		
		List<ProductVo> list6 = repository.findByData(1, "물티슈");  // findAllData() 메소드는 직접 만든 메소드
		
		for(ProductVo vo6: list6) {
			System.out.println(vo6.getCode() + " " + vo6.getSang() + " " + vo6.getSu() + " " + vo6.getDan());
		}
	}
}