package spr12aop_login;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
	@Around("execution(public void startProcess())")
	public Object adv(ProceedingJoinPoint joinpoint) throws Throwable {
		
		System.out.println("AOP 시작 : 핵심 로직 수행 전 ID 검증");
		
		System.out.print("Input ID :");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		sc.close();
		
		if(!id.equals("user")) {
			System.out.println("ID 불일치! 작업을 종료합니다.");
			return null;  // 다음 행(핵심 메소드) 수행하지 않음.
		}
		
		Object object = joinpoint.proceed();  // 이 행이 수행하는 메소드는 13행의 startProcess() 메소드임.
		
		return object;
	}
}
