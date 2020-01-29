package test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect			// aspect 역할을 할 수 있도록 Aspect 어노테이션도 추가한다.
@Component		// bean이 될 수 있도록 컴포넌트를 어노테이션 한다. 뿐만 아니라 ▲
public class PenAspect {
	/*
	 * Spring이 관리하는 객체의 메소드 중에서 
	 * 리턴 타입은 void 메소드명은 write1 메소드에 전달되는 인자는 없는 메소드의 수행 이전에 할 작업
	 */
	@Before("execution(void write*())")	
	// 스프링이 관리하고 있는 메소드 중에서 괄호 안의 메소드(void write1())가 수행되기 이전에 이 아래의 메소드를 수행하라는 의미
	public void prepare() {
		System.out.println("Prepare a pen for writing!");
	}
}
