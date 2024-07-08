package pack.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Customer daniel = (Customer)context.getBean("customer");  // Customer 클래스의 객체 변수
		daniel.selectBank("shinhan");  // 은행 선택
		daniel.playInputMoney(10000);  // 입금
		daniel.playOutputMoney(7000);  // 출금
		System.out.print("고객 daniel님의 ");
		daniel.showMoney();
		
		
		Customer john = (Customer)context.getBean("customer");  // Customer 클래스의 객체 변수
		john.selectBank("shinhan");  // 은행 선택
		john.playInputMoney(3000);  // 입금
		john.playOutputMoney(7000);  // 출금
		System.out.print("고객 john님의 ");
		john.showMoney();
		
		Customer oscar = (Customer)context.getBean("customer");  // Customer 클래스의 객체 변수
		oscar.selectBank("hana");  // 은행 선택
		oscar.playInputMoney(3000);  // 입금
		oscar.playOutputMoney(6000);  // 출금
		System.out.print("고객 oscar님의 ");
		oscar.showMoney();
		
		System.out.println("daniel 객체 주소 : " + daniel);
		System.out.println("john 객체 주소 : " + john);
		System.out.println("oscar 객체 주소 : " + oscar);
	}

}
