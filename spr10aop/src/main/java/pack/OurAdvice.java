package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// Aspect 클래스 : 관심 사항을 담은 클래스(Advice용)
public class OurAdvice {
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable {
		// 수행 시간 체크(관심사항에 해당)
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();  // 스탑워치 시작
		
		System.out.println("핵심 메소드 수행 전 관심사항 실행");  // 로그인, 트랜잭션 등
		
		Object object = joinPoint.proceed();  // 메소드가 무엇이든 파라미터는 joinPoint이어야함, 핵심 메소드 수행
		
		System.out.println("핵심 메소드 수행 후 뭔가를 실행");
		
		stopWatch.stop();  // 스탑워치 종료
		System.out.println("처리 시간 : " + stopWatch.getTotalTimeMillis());
		
		return object;
	}
}
