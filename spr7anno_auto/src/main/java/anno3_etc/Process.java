package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("data")
public class Process {
	// @value : 변수에 값을 초기화하기 위해 사용할 수도 있다.
	// Spring EL : #{표현식}, 만들어진 Component 객체를 이용, private은 getter를 
	// SpEL 표현식은 # 기호로 시작하며 중괄호로 묶어서 표현한다. #{표현식}
	// 속성 값을 참조할 때는 $ 기호와 중괄호로 묶어서 표현한다. ${property.name}
	@Value("#{dataInfo.name}")  // dataInfo 인스턴스에 name 값 주입 <- DataInfo 클래스의 멤버 필드에 선언된 값 할당
	private String name;
	private String part;
	
	@Autowired
/*	// @Value 어노테이션 사용 예시 1 -> 영업부 출력
	public Process(@Value("영업부") String part) {
		this.part = part;
	}
*/	
	// @Value 어노테이션 사용 예시 2 -> 전산부 출력
	public Process(@Value("#{dataInfo.part}") String part) {  // 이 경우는 DataInfo 클래스에 선언된 멤버 필드 part 값을 매개변수 값으로 전달
		this.part = part;
	}
	
	// @Value 어노테이션 사용 예시 3
	@Value("123.1")  // 이렇게 사용하면 에러 X
	//@Value(123) -> Value 어노테이션에 값을 전달할 때 기본적으로 String 타입을로 전달해야 한다. 오류 발생!
	private double age;
	
	@Value("1,2,3,4") // 배열의 초기치로 값이 전달된다.
	private int arr[];
	
	
	
	public void showData() {
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("age : " + age);
		System.out.println("arr[0] : " + arr[0]);
	}
}
