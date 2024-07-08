package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration  // 환경을 여기서 설정할 것이라는 것을 알려준다. -> xml 파일을 작성하지 않아도 됨.
@ComponentScan(basePackages = "anno1_auto") // scan을 만났을 때, 객체가 생성이 된다.
public class Main1 {

	public static void main(String[] args) {
		// @Autowired에 대한 Main 메소드
		// XML 파일을 삭제해도 됨.
		// 어노테이션을 사용한 방법
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main1.class);
		
		// xml 파일을 사용하는 방법
//		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		
		process.displayData();
	}
}
