package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprweb05Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb05Application.class, args)
			.getBean(Sprweb05Application.class).execute();	
	}
	
	@Autowired
	My my;
	
	@Autowired
	ProcessServiceImpl processServiceImpl;
	
	private void execute() {
		System.out.println("execute 메소드 수행");
		my.method1();
		
		processServiceImpl.selectProcess();
	}

}
