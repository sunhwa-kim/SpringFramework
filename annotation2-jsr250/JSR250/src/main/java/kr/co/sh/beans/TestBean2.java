package kr.co.sh.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean2 {

	public TestBean2() {
		System.out.println(" > 2 생성자");
	}
	
	// 생성자 호출 이후 자동 호출
	@PostConstruct
	public void init2() {
		System.out.println(" > 2 init method");
	}
	
	// 객체 소멸되기 전 호출
	@PreDestroy
	public void destroy2() {
		System.out.println(" > 2 destroy method");
	}
}
