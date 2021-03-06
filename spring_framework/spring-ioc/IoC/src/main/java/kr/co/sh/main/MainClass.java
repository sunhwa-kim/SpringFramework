package kr.co.sh.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.sh.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
		test4();
	}
	
	// BeanFactory - 패키지 내부
	public static void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/sh/config/beans.xml");
		// IoC container
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		// ClassPathResource로는 로딩시 기본적으로 자동으로 bean 객체 생성 안됨 - 생성
		TestBean t1 = factory.getBean("t1", TestBean.class);
		System.out.printf("t1 :%s\n", t1);
		
		TestBean t2 = factory.getBean("t1", TestBean.class);
		System.out.printf("t2 :%s\n", t2);   // 동일한 주소값 확인
	}

	// BeanFactory - 패키지 외부
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		// 로딩시 등록된 bean 객체 생성되게
		TestBean t1 = factory.getBean("t2", TestBean.class);
		System.out.printf("t1 :%s\n", t1);
		
		TestBean t2 = factory.getBean("t2", TestBean.class);
		System.out.printf("t2 :%s\n", t2);  // 동일한 주소값 확인
	}
	
	// ApplicationContext - 패키지 내부
	public static void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		// beans.xml 에 정의된 bean 객체들 자동 생성 O - 조절 가능
		// (별도 생성해야 했던) BeanFactory와 다르게 만들어진 객체의 주소값을 가져와서 이용
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1 :%s\n", t1);
		
		TestBean t2 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t2 :%s\n", t2);
		ctx.close();
	}
	 
	// ApplicationContext - 패키지 외부
		public static void test4() {
			FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
			// beans.xml 에 정의된 bean 객체들 자동 생성 O - 조절 가능
			
			TestBean t1 = ctx.getBean("t2", TestBean.class);
			System.out.printf("t1 :%s\n", t1);
			
			TestBean t2 = ctx.getBean("t2", TestBean.class);
			System.out.printf("t2 :%s\n", t2);
			ctx.close();
		}
}
