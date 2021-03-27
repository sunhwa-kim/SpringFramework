package kr.co.sh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.HelloWorld;

public class MainClass {

	public static void main(String[] args) {
		// beans.xml ���� �ε�
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		// xml ������ bean ��ü�� �ּҰ��� �����´�.
		HelloWorld hello1 = (HelloWorld) ctx.getBean("hello");
		callMethod(hello1);
		
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);   // �ߺ� ���� �߻� ���� ����
		callMethod(hello2);
		
		ctx.close();
	}

	public static void callMethod(HelloWorld hello) {
		hello.sayhello();
	}
}