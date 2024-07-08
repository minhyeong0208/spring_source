package anno1_auto;

import org.springframework.stereotype.Component;

@Component  // singleton 패턴으로 Sender 객체가 생성. 객체 변수명은 sender가 된다.
//@Component("sender")
//@Component("sen")
//@Scope("singleton")
public class Sender implements SenderInter {  // SenderInter 타입의 Sender 클래스
	@Override
	public void show() {
		System.out.println("Sender 클래스의 show 메소드 수행");
	}
}
