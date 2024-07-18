package other;

import org.springframework.stereotype.Component;

@Component
public class OtherClass {
	public OtherClass() {
		System.out.println("OtherClass 객체 생성");
	}
	
	public void method() {
		System.out.println("OtherClass 클래스 내 method() 실행");
	}
}
