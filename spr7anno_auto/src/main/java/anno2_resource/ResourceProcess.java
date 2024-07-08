package anno2_resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ResourceProcess {
	@Resource(name="resourceAnno1")  // type에 의한 매핑이 아니라 객체 변수 이름으로 매핑!
	private ResourceAnno1 resourceAnno1;  // 필드 주입용
	private ResourceAnno2 resourceAnno2;  // 세터 주입용
	
	@Resource(name="test")  // ResourceAnno2 클래스의 객체 변수 이름을 test로 설정함. @Component 어노테이션에서
	public void setResourceAnno2(ResourceAnno2 resourceAnno2) {
		this.resourceAnno2 = resourceAnno2;
	}
	
	public void showData() {
		resourceAnno1.setName("하이");
		resourceAnno2.setage(25);
		
		String str = "이름 : " + resourceAnno1.getName();
		str += "\n나이 : " + resourceAnno2.getage();
		System.out.println(str);
	}
}
