package kr.co.sh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.sh.beans.TestBean2;

@Configuration
@ComponentScan(basePackages = "kr.co.sh.beans")
public class BeanConfigClass {
	
	// 동일 클래스 타입  bean을 다른 이름 통해 사용하고자 할 때
	// 같은 클래스 타입의 bean 여러개 사용위한 !=singleton
	@Bean
	public TestBean2 t5() {
		return new TestBean2();
	}
	@Bean
	public TestBean2 t6() {
		return new TestBean2();
	}
}
