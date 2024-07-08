package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		
		OurProcess our = (OurProcess)context.getBean("our"); // Object 타입으로 context.getBean()이 넘어오므로 casting이 필요.
		System.out.println(our);
		
	}

}
