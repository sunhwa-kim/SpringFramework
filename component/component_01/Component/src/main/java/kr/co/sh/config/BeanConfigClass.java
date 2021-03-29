package kr.co.sh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.beans2.TestBean4;

@Configuration
// 지정된 패키지의 Bean 클래스들의 어노테이션 분석하여 Bean 등록 지정
@ComponentScan(basePackages = "kr.co.sh.beans2")
@ComponentScan(basePackages = "kr.co.sh.beans3")
public class BeanConfigClass {

	@Bean
	public TestBean1 java1() {  // 타입
		return new TestBean1();
	}
	
	@Bean
	public TestBean2 java2() {  // 이름
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean4 java100() {
		return new TestBean4();
	}
	
	@Bean
	public TestBean4 java200() {
		return new TestBean4();
	}
}
