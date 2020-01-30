package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessengerAspect {
	/*
	 * 1. 리턴 type은 상관없다
	 * 2. 메소드명이 send로 시작하는 메소드
	 * 3. 메소드에 전달되는 인자도 상관없다
	 * 
	 * 위의 3가지 조건을 모두 만족시키는 메소드에 아래의 AOP가 적용된다.
	 */
	@Around("execution(* send*(..))")
	public void around(ProceedingJoinPoint joinPoint) 		// @Around에만 joinPoint 존재 (@Before와 @After에는 없다)
			throws Throwable {
		// aop가 적용된 메소드 수행 직전
		System.out.println("--- Before the working ---");
		
		// aop가 적용된 메소드에 전달된 인자를 Object[]로 얻어낼 수 있다.
		Object[] args=joinPoint.getArgs();
		// 반복문 돌면서 찾고싶은 type을 찾는다
		for(Object tmp:args) {
			if(tmp instanceof String) {		// 만일 String type이면
				// 원래 type으로 casting
				String msg=(String)tmp;
				System.out.println("Read from AOP : "+msg);
				if(msg.contains("Every")) {
					System.out.println("Do NOT use the word 'Every'");
					return;			// 메소드를 여기서 종료시킨다
				}
			}
		}
		
		// aop가 적용된 메소드 수행하고 리턴되는 값 받아오기 (void(=아무것도 리턴해주는 것이 없다면) null이다)
		Object obj=joinPoint.proceed();
		
		// aop가 적용된 메소드 리턴 직후
		System.out.println("--- After the working ---");
	}
	
	
	@Around("execution(String getMessage())")
	public Object around2(ProceedingJoinPoint joinPoint) 
			throws Throwable {
		// aop가 적용된 메소드를 수행하고 리턴되는 값을 얻어낸다.
		Object obj=joinPoint.proceed();
		
		// 리턴할 값을 조작하기
		obj="Let's go to the Disneyland!!!";
		
		// 리턴되는 값을 다시 리턴해주기
		return obj;
	}
	
}
