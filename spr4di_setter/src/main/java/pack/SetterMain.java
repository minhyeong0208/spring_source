package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		
		MyProcess myProcess = (MyProcess)context.getBean("myProcess"); // Object 타입으로 context.getBean()이 넘어오므로 casting이 필요.
		myProcess.displayData();
		
	}

}
