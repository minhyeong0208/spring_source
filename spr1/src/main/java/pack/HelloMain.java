package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리 1 : 레거시한 방법
		Message1 m1 = new Message1();
		m1.sayHello("홍길동");
		
		Message2 m2 = new Message2();
		m2.sayHello("신선해");
			
		
		MessageInter inter;
		inter = m1;
		inter.sayHello("손오공");
		
		inter = m2;
		inter.sayHello("저팔계");
		
		
		// 처리 2 : Spring 방법
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");  // classpath root : src/main/resources를 의미
		
		// 아래 코드는 init.xml 파일을 pack 패키지로 이동시켰을 경우, 실행하는 코드
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/init.xml");
		
		MessageInter inter2 = (MessageInter)context.getBean("mes1");  // init.xml에 선언한 mes1 객체 호출, type mismatch!
		inter2.sayHello("보라돌이");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("뚜비");
		
	}

}
