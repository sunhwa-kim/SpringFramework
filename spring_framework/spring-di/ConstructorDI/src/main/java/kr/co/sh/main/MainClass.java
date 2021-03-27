package kr.co.sh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.DataBean;
import kr.co.sh.beans.TestBean;
import kr.co.sh.beans.TestBean2;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");

		// java로 객체 생성
		TestBean t1 = new TestBean();
		t1.printData();

		System.out.println("  ---------  -----------");
		
		TestBean t2 = new TestBean(222);
		t2.printData();
		
		System.out.println("  ---------  -----------");

		TestBean t3 = new TestBean(22.22);
		t3.printData();
		
		System.out.println("  ---------  -----------");

		TestBean t4 = new TestBean("문자열");   // 스프링 생성자는 String으로 변화
		t4.printData();
		
		System.out.println("  ---------  -----------");
		
		TestBean t5 = new TestBean(300, 33.33, "Hi ~*");   // 매개변수 순서 메서드 정의 순서대로 
		t5.printData();
		
		System.out.println("  ---------  -----------");
		
		TestBean obj1 = ctx.getBean("obj1", TestBean.class);
		obj1.printData();
		
		System.out.println("  ---------  -----------");
		TestBean obj2 = ctx.getBean("obj2", TestBean.class);
		obj2.printData();
		
		System.out.println("  ---------  -----------");
		// Spring에서 int 보다 double 우선
		TestBean obj3 = ctx.getBean("obj3", TestBean.class);
		obj3.printData();
		
		System.out.println("  ---------  -----------");
		// Spring에서 double 보다 String 우선
		TestBean obj4 = ctx.getBean("obj4", TestBean.class);
		obj4.printData();
		
		System.out.println("  ---------  -----------");
		TestBean obj5 = ctx.getBean("obj5", TestBean.class);
		obj5.printData();
		
		System.out.println("  ---------  -----------");
		TestBean obj6 = ctx.getBean("obj6", TestBean.class);  // 순서 변경 가능 - but 순서 지키자
		obj6.printData();
		
		System.out.println("  ---------  -----------");
		TestBean obj7 = ctx.getBean("obj7", TestBean.class);  // 순서 지정 - 단 생성자의 매겨변수 순서를 index로 맞춘다
		obj7.printData();
		
		System.out.println("  ---------  -----------");
		DataBean d1 = new DataBean();
		DataBean d2 = new DataBean();
		TestBean2 t02 = new TestBean2(d1,d2);
		t02.printData();
		
		System.out.println("  ---------  -----------");
		TestBean2 obj8 = ctx.getBean("obj8", TestBean2.class);  // 순서 지정 - 단 생성자의 매겨변수 순서를 index로 맞춘다
		obj8.printData();
		
		System.out.println("  ---------  -----------");
		TestBean2 obj9 = ctx.getBean("obj9", TestBean2.class);  // 순서 지정 - 단 생성자의 매겨변수 순서를 index로 맞춘다
		obj9.printData();
		
		
		ctx.close();
	}

}
