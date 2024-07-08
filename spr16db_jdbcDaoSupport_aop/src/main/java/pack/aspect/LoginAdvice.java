package pack.aspect;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 관심사항
@Component
@Aspect
public class LoginAdvice {  
	@Around("execution(public void jikwonList())")
	public Object Login(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.print("로그인 아이디 입력 : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();

		if(!id.equalsIgnoreCase("kor")) {
			System.out.println("ID 불일치, 로그인 실패");
			return null;
		}
		
		Object object = joinPoint.proceed();
		sc.close();
		return object;
	}
}
