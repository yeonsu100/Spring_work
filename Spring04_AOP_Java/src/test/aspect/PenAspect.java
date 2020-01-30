package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect			// aspect 역할을 할 수 있도록 Aspect 어노테이션도 추가한다.
@Component		// bean이 될 수 있도록 컴포넌트를 어노테이션 한다. 뿐만 아니라 ▲
public class PenAspect {
	/*
	 * Spring이 관리하는 객체의 메소드 중에서 
	 * 리턴 타입은 void 메소드명은 write1 메소드에 전달되는 인자는 없는 메소드의 수행 이전에 할 작업
	 * 
	 * - @Before : 수행 이전에 하고싶을 때
	 * - @After : 수행 이후에 하고싶을 때
	 * - @Around : 이전, 이후 모두 수행하고 싶을 때 (기능이 많기 때문에 주로 사용된다)
	 */
	@Before("execution(void write*())")	
	// 스프링이 관리하고 있는 메소드 중에서 괄호 안의 메소드(void write1())가 수행되기 이전에 이 아래의 메소드를 수행하라는 의미
	public void prepare() {
		System.out.println("Prepare a pen for writing!");
	}
	
	@After("execution(void write*())")
	public void end() {
		System.out.println("Finish using a pen!");
	}
	
}
