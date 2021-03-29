package kr.co.sh.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// getBean 메서드 호출 마다 새로 객체 생성 : no singleton
@Scope("prototype")
public class TestBean4 {

	public TestBean4() {
		System.out.println(" > 4 생성자");
	}
}
