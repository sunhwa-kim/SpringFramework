package kr.co.sh.beans;

import org.springframework.stereotype.Component;

// IoC 컨테이너가 만들어 질 때 자동 객체 생성
// 객체 주소값 참조시 이름 통해 가능
// singleton
@Component("t3")
public class TestBean2 {
	
	public TestBean2() {
		System.out.println(" > 2 생성자");
	}

}
