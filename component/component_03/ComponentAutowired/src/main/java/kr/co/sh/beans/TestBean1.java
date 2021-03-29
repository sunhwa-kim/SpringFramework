package kr.co.sh.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestBean1 {

	@Autowired
	private DataBean1 data1;
	
	@Autowired
	@Qualifier("obj2")  // 이름주입
	private DataBean2 data2;
	
	@Resource(name="obj3")  // 이름주입 jsr250
	private DataBean3 data3;
	
	@Resource(name="obj4")   // 설정 클래스에 등록
	private DataBean3 data4;
	@Resource(name="obj5")
	private DataBean3 data5;

	public DataBean1 getData1() {
		return data1;
	}

	public DataBean2 getData2() {
		return data2;
	}

	public DataBean3 getData3() {
		return data3;
	}

	public DataBean3 getData4() {
		return data4;
	}

	public DataBean3 getData5() {
		return data5;
	}
	
	
	
	
}
