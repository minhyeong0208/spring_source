package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopinit.xml");
		
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.selectDataProcess1();
		inter.selectDataProcess2();
		// 현재 AOP 없이 핵심 로직만 존재하는 상태
		
		// 관심 사항을 특정 메소드(selectDataProcess1,selectDataProcess2)에 밀어 넣을 예정
		// 관심사항을 가지고 있는 클래스가 필요 -> OurAdvice 클래스
	}
}
