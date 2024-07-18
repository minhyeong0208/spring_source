package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args)
				.getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	private ProductCrudRepository crudRepository;
	
	@Autowired
	OtherClass class1;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행 가능.");
		
//		insertData();
		updateData();
		deleteData();
		selectData();
		
		class1.method();
	}
	
	private void insertData() {
		// auto_increment이므로 첫 번째 인자는 null 전달
		ProductVo productVo = new ProductVo(null, "볼펜", 2, 1000);  // ProductVo 클래스에 @AllArgsConstructor 어노테이션에 의해 생성자로 값을 전달 가능.
		
		// save() : 없는 번호에 대해 save()를 실행하는 경우, 데이터 추가. 
		crudRepository.save(productVo); 
	}
	
	private void updateData() {
		ProductVo productVo = new ProductVo(2, "사랑비", 10, 2000);  
		
		// save() : 있는 번호에 대해 save()를 실행하는 경우, 데이터 변경. -> save() 메소드로 삽입 및 수정 가능.
		crudRepository.save(productVo); 
	}
	
	private void deleteData() {
		// deleteById() : 해당 아이디 값 데이터 삭제
		// deleteAll() : 전체 데이터 삭제
		crudRepository.deleteById(5);
	}
	
	
	
	// JPA를 사용하는 이유는 Dialect를 지원하여 소스 코드를 변경하지 않아도 된다.
	// SQL문이 내부적으로 실행되고 있다.
	private void selectData() {
		// findAll() : 전체 레코드 읽기 -> 내부적으로 select * from product를 실행
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll();
		
		for(ProductVo p: list) {
			System.out.println(p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		
		System.out.println();
		
		// findById(PK) : 1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
	}
}