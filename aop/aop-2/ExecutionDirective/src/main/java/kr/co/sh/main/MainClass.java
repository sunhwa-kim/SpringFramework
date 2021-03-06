package kr.co.sh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;

public class MainClass {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		TestBean1 xml1 = ctx.getBean("xml1", TestBean1.class);
		TestBean2 xml2 = ctx.getBean("xml2", TestBean2.class);
		kr.co.sh.beans2.TestBean1 xml3 = ctx.getBean("xml3", kr.co.sh.beans2.TestBean1.class);
		
		xml1.method1();
		
		System.out.println(" ----------------------------------- ");
		
//		xml1.method2();  // 관심사 설정 되지 않음메서드 = weaving X - 관심사 차이 확인
		xml1.method1(100);  // weaving O/X 확인
		
		System.out.println(" ----------------------------------- ");
		
		xml1.method1("문자열");
		
		System.out.println(" ----------------------------------- ");
		
		xml1.method1(1000,2000);
		
		System.out.println(" ----------------------------------- ");
		
		xml1.method1(100, "문자열");
		
		System.out.println(" ----------------------------------- ");
		
		xml1.method2();  // 메서드 관심사 아닐때
		
		System.out.println(" ----------------------------------- ");
		
		xml2.method1();
		
		System.out.println(" ----------------------------------- ");

		xml3.method1();  // 다른 패키지
		
		System.out.println(" ----------------------------------- ");
		
		int a1 = xml1.method3();
		System.out.printf("a1 : %d\n",a1);  // 반환타입이 달라서 != 모든패키지, 모든클래스, 모든메서드
		
		
		ctx.close();
	}

}
