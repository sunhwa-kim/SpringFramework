package kr.co.sh.beans;

import org.springframework.stereotype.Component;

// IoC 객체 생성시 자동 객체 생성
// Singleton
@Component  // bean 등록+타입+가져오기
public class TestBean1 {

	public TestBean1() {
		System.out.println(" > 1 생성자");
	}
}
