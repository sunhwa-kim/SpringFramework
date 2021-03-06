package kr.co.sh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		// id=test1인 bean 객체의 주소값 받아오기
		TestBean test1 = ctx.getBean("test1", TestBean.class);
		System.out.printf("test1 :%s\n", test1);
		
		TestBean test2 = ctx.getBean("test1", TestBean.class);
		System.out.printf("test2 :%s\n", test2);
		
		// id=test2인 bean 객체의 주소값 받아오기 - 생성자 3개 확인
		// 이전까진, lazy-init 제외한 2개 생성자만 확인
		TestBean test3 = ctx.getBean("test2", TestBean.class);
		System.out.printf("test3 :%s\n", test3);
		
		TestBean test4 = ctx.getBean("test2", TestBean.class);
		System.out.printf("test3 :%s\n", test4);  // 생성 아닌 주소값만 받아온다
		
		// id = test3 bean 객체 주소값 받아오기
		TestBean test5 = ctx.getBean("test3", TestBean.class);
		System.out.printf("test5 :%s\n", test5);
		
		TestBean test6 = ctx.getBean("test3", TestBean.class);
		System.out.printf("test6 :%s\n", test6);  // 생성
		
		ctx.close();
	}

}
