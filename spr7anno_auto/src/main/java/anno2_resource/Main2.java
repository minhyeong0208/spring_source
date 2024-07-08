package anno2_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:anno2.xml");
		
		ResourceProcess process = context.getBean("resourceProcess", ResourceProcess.class);
		process.showData();
	}

}
