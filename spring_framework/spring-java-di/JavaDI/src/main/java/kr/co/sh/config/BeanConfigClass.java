package kr.co.sh.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.sh.beans.DataBean1;
import kr.co.sh.beans.DataBean2;
import kr.co.sh.beans.DataBean3;
import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.beans.TestBean3;

	@Configuration
public class BeanConfigClass {

	@Bean
	public TestBean1 java1() {
		return new TestBean1(200, "문자열2", new DataBean1());
	}   
	
	@Bean
	public TestBean1 java2() {
		TestBean1 t1 = new TestBean1();
		t1.setData1(400);
		t1.setData2("문자열4");
		t1.setData3(new DataBean1());
		return t1;
	}
	
	// 자동주입
	@Bean
	public DataBean2 data1() {  // TestBean2의 메서드명과 똑같게
		return new DataBean2();
	}
	
	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}
	
	// spring 5.1부터 deprecated
	@Bean(autowire = Autowire.BY_NAME)
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	@Bean
	public DataBean3 data100() {
		return new DataBean3();
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public TestBean3 java4() {
		return new TestBean3();
	}
}
