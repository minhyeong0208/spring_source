package aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 핵심 로직에 삽입할 관심 소스코드 
// ex. Transaction, Login, Security, Log...
public class Advice implements MethodInterceptor{
	// 핵심 로직 임의의 메소드에 관심사항을 끼워넣기 위해 사용

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {  // 시스템에 의해 호출됨.
		// joinpoint에 삽입되어 동작할 코드 기술 -> 핵심 로직이 수행되기 전이 수행됨.
		
		System.out.println("핵심 로직 수행 전 뭔가를 처리..");
		// target 메소드 이름 얻기
		String tmname = invocation.getMethod().getName();  // tmn : target method name
		System.out.println("적용된 메소드명 : " + tmname);
		

		Object object = invocation.proceed();  // 선택된 핵심 로직 메소드 중 하나 : 여기서는 sayHi()에 해당, 아직 지정하지는 않은 상태!
		
		
		System.out.println("핵심 로직 수행 후 마무리 처리");
		return object;
	}
}
