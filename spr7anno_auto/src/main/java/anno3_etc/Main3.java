package anno3_etc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:anno3.xml");
		
		Process process = context.getBean("data", Process.class);
		process.showData();
	}

}
