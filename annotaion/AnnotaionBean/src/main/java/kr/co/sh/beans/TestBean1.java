package kr.co.sh.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestBean1 {

	private int data1;
	private DataBean1 data2;
	
	// 자동 주입을 변수에 설정
	// 컴파일로 자동으로 setter 메서드 추가되어 setter 메서드 통해 주입
	// getter 만 추가
	@Autowired
	private DataBean1 data3;
	
	public DataBean1 getData3() {
		return data3;
	}
	
	// 동일 빈이 등록되었을때 
	@Autowired
	@Qualifier("obj4")
	private DataBean2 data4;
	@Autowired
	@Qualifier("obj5")
	private DataBean2 data5;
	
	public DataBean2 getData4() {
		return data4;
	}

	public DataBean2 getData5() {
		return data5;
	}

	@Autowired(required = false) // 없으면 말고(null), 있으면 참조
	@Qualifier("obj6")  // 등록된 bean(obj5)은 ok -> 없는 obj6만으로는 오류 + required = false로  
	private DataBean2 data6;  // 애만으로는 오류 X
	

	public DataBean2 getData6() {
		return data6;
	}
	
	// 생성자 이용한 반드시 주입 프로퍼티
//	public TestBean1(int data) {
//		this.data1 = data;
//	}


	public int getData1() {
		return data1;
	}

	// 필수 주입 프로퍼티 (스프링 5.1부터 자바 빈 등록시 무시)
	@Required  // 반드시 주입
	public void setData1(int data1) {
		this.data1 = data1;
	}

	public DataBean1 getData2() {
		return data2;
	}

	// 자동 주입(타입) - DataBean1
	@Autowired
	public void setData2(DataBean1 data2) {
		this.data2 = data2;
	}

	
}
