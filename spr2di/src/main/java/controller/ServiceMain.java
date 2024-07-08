package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoImpl;

public class ServiceMain {

	public static void main(String[] args) {
		// 전통적인 방법
		// DB 처리 객체 생성
		DataDaoImpl impl = new DataDaoImpl();
		DataDao dataDao = impl;   // 다형성 -> 변수 dataDao는 DataDaoImpl 객체의 주소를 가짐.
		
		// 비즈니스 로직 관련 객체 생성
		ProcessServiceImpl serviceImpl = new ProcessServiceImpl(dataDao);  // 생성자를 통해 dataDao의 주소를 전달
		ProcessService processService =  serviceImpl;
		processService.selectProcess();
		
		
		System.out.println("\n\nSpring 방법");
		// Spring 방법
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		ProcessService processService2 = (ProcessService)context.getBean("serviceImpl");  // init.xml의 bean 태그 id 속성값을 매개변수로 전달
		processService2.selectProcess();
		
	}

}
