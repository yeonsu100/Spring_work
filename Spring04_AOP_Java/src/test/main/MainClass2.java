package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Messenger;

public class MainClass2 {
	public static void main(String[] args) {
		// init.xml 문서를 로딩해서 bean으로 만들 것들은 만들어서 관리한다.
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		Messenger m=context.getBean(Messenger.class);
		m.sendGreeting("Good Morning Winnie!");
		m.sendGreeting("Good Morning Everyone!!");
		
	}
}
