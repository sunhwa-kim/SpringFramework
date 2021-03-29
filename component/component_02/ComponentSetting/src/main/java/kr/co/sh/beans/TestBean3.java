package kr.co.sh.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// getBean 메서드 호출시 객체 생성
// singleton
@Lazy
public class TestBean3 {
	
	public TestBean3() {
		System.out.println(" > 3 생성자");
	}

}
