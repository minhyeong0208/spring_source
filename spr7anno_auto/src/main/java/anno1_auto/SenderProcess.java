package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 아래 세 개의 레이어는 컴포넌트 아래에 존재.
// 참고 : 계층(Layers)별 어노테이션 구분
// Application Layer : 클라이언트와 데이터 입출력을 제어 ex. @Controller ...
// Domain Layer : 애플리케이션 중심이며, 업무처리를 담당 ex. @Service ...
// Infrastructor Layer : DB에 대한 영속성(Persistence) 등을 담당 ex. @Repository ...

@Service  // 객체를 만들어 서비스를 위해 만들어놓은 클래스임을 알려줌.
// 객체 변수의 이름은 senderProcess이다.
// @Service("senderProcess")
// @Scope("singleton")
// @Service는 위 두 행과 동일하다.
public class SenderProcess {
	//@Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션. (name에 의한 매핑이 아니라 type으로 매핑됨)
	
//	field injection : 간단하나 테스트가 불편함. 주로 사용
//	@Autowired  
//	private Sender sender;
	// Sender 클래스에 @Component를 사용하여 Sender 타입의 객체가 만들어져 있어야 함. ?
	// 위에서 만들어 놓은 인스턴스 주소가 field 값으로 전달된다. ?
	
	@Autowired  // 해당 어노테이션이 이름으로 찾는 게 아니라 타입으로 찾으므로 에러가 발생한다!
	@Qualifier("sender")  // senderInter 타입이 두 개가 있는데 sender 객체를 호출한다는 의미!
	private Sender sender;  // Sender 인스턴스의 주소를 넘겨주는데 Sender 클래스의 주소를 이곳에 와이어링함.
	
		
	//@Autowired  // setter injection : 코드가 장황해짐.
//	public void setSender(Sender sender) {
//		this.sender = sender;
//	}
	/*
	@Autowired  // constructor injection : 불변성과 테스트가 편하지만 생성자가 많아질 수 있음.
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}

	public Sender getSender() {
		return sender;
	}
*/	
	public void displayData() {
		sender.show();
	}
}
