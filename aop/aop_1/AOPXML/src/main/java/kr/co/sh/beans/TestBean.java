package kr.co.sh.beans;

public class TestBean {

	public int method1() {  // 관심사
		System.out.println(" > method 1 호출");
		
		// afterReturning 확인 위한 예외
		int a1 = 10/0;  // 주석하며 after returning/ throwing 확인
		
		return 1000;
	}
}
