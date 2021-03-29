package kr.co.sh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean(TestBean1.class);
		try {
			xml1.method1();
		} catch (Exception e) {
		}
		
		
		ctx1.close();
		
		System.out.println(" =================================================== ");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 java1 = ctx.getBean(TestBean1.class);
		try {
			java1.method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		ctx.close();
	}

}
