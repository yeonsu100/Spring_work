package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.WritingUtil;

public class MainClass {
	public static void main(String[] args) {
		// init.xml 문서를 로딩해서 bean으로 만들 것들은 만들어서 관리한다.
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		
		// 관리하고 있는 객체중에서 WritingUtil type의 참조값 얻어오기
		WritingUtil util=context.getBean(WritingUtil.class);
		
		util.write1();
		util.write2();
		util.write3();
	}
}
