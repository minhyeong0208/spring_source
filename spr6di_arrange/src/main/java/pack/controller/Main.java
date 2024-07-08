package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml");
		// 아래 방식 사용 시, context 객체 close 가능
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("arrange.xml");
		
		System.out.println("Sigleton / Prototype 확인");
		// MessageInter 인터페이스를 구현한 MessageImpl 클래스 타입의 객체를 생성 후, 
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		// 해당 클래스에 오버라이딩된 메소드 sayHi() 메소드를 실행
		impl1.sayHi();
		
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		// 해당 클래스에 오버라이딩된 메소드 sayHi() 메소드를 실행
		impl2.sayHi();
		
		// 객체 impl1, impl2의 주소 확인
		System.out.println("\nimpl1 주소 : " + impl1);
		System.out.println("impl2 주소 : " + impl2);
		// bean 태그의 scope가 singleton인 경우, 두 주소는 동일
		// scope가 prototype인 경우, 다른 객체를 호출하므로 주소가 다름
		
		
		System.out.println("\n다형성 처리");
		// 다형성 처리를 위해 interface 타입의 객체 사용
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		// 다음과 같이 두번째 인수(인터페이스 타입)를 전달하면 casting이 필요 없음
		MessageInter inter2 = context.getBean("mImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();
	}

}
