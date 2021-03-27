package kr.co.sh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.HelloWorld;

public class MainClass {

	public static void main(String[] args) {
		// beans.xml 파일 로딩
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		// xml 정의한 bean 객체의 주소값을 가져온다.
		HelloWorld hello1 = (HelloWorld) ctx.getBean("hello");
		callMethod(hello1);
		
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);   // 중복 문제 발생 방지 가능
		callMethod(hello2);
		
		ctx.close();
	}

	public static void callMethod(HelloWorld hello) {
		hello.sayhello();
	}
}
