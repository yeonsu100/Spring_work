package test.security;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Insert a character");
		String str=scan.nextLine();
		// 문자열을 암호화해주는 객체 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		// 입력한 문자열을 암호화한다.
		String result=encoder.encode(str);
		System.out.println("Inserted character : "+str);
		System.out.println("Secured character : "+result);
	}
}
