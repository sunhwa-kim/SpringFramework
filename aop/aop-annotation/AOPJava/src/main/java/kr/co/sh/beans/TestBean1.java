package kr.co.sh.beans;

import org.springframework.stereotype.Component;

@Component
public class TestBean1 {

	public void method1() throws Exception {
		System.out.println(" > TestBean1.method1 >");
		
		// afterReturningMethod 확인위한 예외 발생
//		int a1 = 10/0;
	}
}
