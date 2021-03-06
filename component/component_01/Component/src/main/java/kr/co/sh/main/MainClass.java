package kr.co.sh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.beans2.TestBean3;
import kr.co.sh.beans2.TestBean4;
import kr.co.sh.beans3.TestBean5;
import kr.co.sh.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean(TestBean1.class);
		System.out.printf("xml1 : %s\n", xml1);
		
		System.out.println("----------------------------------------------");
		
		// 동일 타입
		TestBean2 xml2 = ctx1.getBean("xml2", TestBean2.class);
		System.out.printf("xml2 : %s\n", xml2);
		TestBean2 xml3 = ctx1.getBean("xml3", TestBean2.class);
		System.out.printf("xml3 : %s\n", xml3);
		
		System.out.println("----------------------------------------------");
		// <context:component-scan base-package= ""/> 
		// 타입 통한
		TestBean3 xml4 = ctx1.getBean(TestBean3.class);
		System.out.printf("xml4 : %s\n", xml4);
		
		System.out.println("----------------------------------------------");
		// Component - 이름 등록된 애 xml로 불러오기
		TestBean4 xml5 = ctx1.getBean("bean4", TestBean4.class);
		System.out.printf("xml5 : %s\n", xml5);
		
		System.out.println("----------------------------------------------");
		// Component - 동일 클래스 여러 이름으로
		TestBean4 xml100 = ctx1.getBean("xml100", TestBean4.class);
		System.out.printf("xml100 : %s\n", xml100);
		TestBean4 xml200 = ctx1.getBean("xml200", TestBean4.class);
		System.out.printf("xml200 : %s\n", xml200);
		
		System.out.println("----------------------------------------------");
		// Component 패키지 추가
		TestBean5 xml500 = ctx1.getBean(TestBean5.class);
		System.out.printf("xml500 : %s\n", xml500);
		
		
		ctx1.close();
		
		System.out.println(" ================================================= ");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		// 타입
		TestBean1 java1 = ctx.getBean(TestBean1.class);
		System.out.printf("java1 : %s\n", java1);
		
		System.out.println("----------------------------------------------");
		// 이름
		TestBean2 java2 = ctx.getBean("java2", TestBean2.class);
		System.out.printf("java2 :%s\n", java2); 
		TestBean2 java3 = ctx.getBean("java3", TestBean2.class);
		System.out.printf("java3 :%s\n", java3); 
		
		System.out.println("----------------------------------------------");
		// Component
		TestBean3 java4 = ctx.getBean(TestBean3.class);
		System.out.printf("java4 : %s\n", java4);
		
		
		System.out.println("----------------------------------------------");
		// Component - 이름
		TestBean4 java5 = ctx.getBean("bean4",TestBean4.class);
		System.out.printf("java5 : %s\n", java5);
		
		System.out.println("----------------------------------------------");
		// Component - 동일 클래스(타입) 여러 이름으로 bean 불러오기
		TestBean4 java100 = ctx.getBean("java100",TestBean4.class);
		System.out.printf("java100 : %s\n", java100);
		TestBean4 java200 = ctx.getBean("java200",TestBean4.class);
		System.out.printf("java200 : %s\n", java200);
		
		System.out.println("----------------------------------------------");
		// @Component 패키지 추가
		TestBean5 java500 = ctx.getBean(TestBean5.class);
		System.out.printf("java500 : %s\n", java500);
		
		ctx.close();
		
	}

}
