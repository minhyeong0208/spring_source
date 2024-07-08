package anno1_auto;

import org.springframework.stereotype.Component;

@Component
public class Sender2 implements SenderInter {
	
	@Override
	public void show() {
		System.out.println("Sender 2 클래스의 show() 처리");	
	}
}
