package test.example1;

import test.mypac.Weapon;			// 인터페이스
import test.mypac.WeaponImpl;		// 클래스

public class MainClass {
	public static void main(String[] args) {
		// useWeapon() 메소드를 호출하는게 목적이라면?
		
		// 필요한 type 객체를 직접 생성해서
		WeaponImpl w1=new WeaponImpl();
		// 메소드를 호출함으로써 목적을 달성한다.
		useWeapon(w1);
	}
	
	// Weapon(인터페이스) type을 전달해야 호출할 수 있는 메소드
	public static void useWeapon(Weapon w) {
		w.attack();
	}
}
