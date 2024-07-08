package spr12aop_login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @Configuration : 이 어노테이션을 사용하면 XML 작성 필요 X
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
	
		BusinessLogicInter inter = (BusinessLogicInter)context.getBean("bImpl");
		inter.startProcess();
	}
}
