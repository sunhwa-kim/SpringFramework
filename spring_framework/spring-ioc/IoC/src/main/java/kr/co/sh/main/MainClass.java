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
	
	// BeanFactory - ��Ű�� ����
	public static void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/sh/config/beans.xml");
		// IoC container
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		// ClassPathResource�δ� �ε��� �⺻������ �ڵ����� bean ��ü ���� �ȵ� - ����
		TestBean t1 = factory.getBean("t1", TestBean.class);
		System.out.printf("t1 :%s\n", t1);
		
		TestBean t2 = factory.getBean("t1", TestBean.class);
		System.out.printf("t2 :%s\n", t2);   // ������ �ּҰ� Ȯ��
	}

	// BeanFactory - ��Ű�� �ܺ�
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		// �ε��� ��ϵ� bean ��ü �����ǰ�
		TestBean t1 = factory.getBean("t2", TestBean.class);
		System.out.printf("t1 :%s\n", t1);
		
		TestBean t2 = factory.getBean("t2", TestBean.class);
		System.out.printf("t2 :%s\n", t2);  // ������ �ּҰ� Ȯ��
	}
	
	// ApplicationContext - ��Ű�� ����
	public static void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		// beans.xml �� ���ǵ� bean ��ü�� �ڵ� ���� O - ���� ����
		// (���� �����ؾ� �ߴ�) BeanFactory�� �ٸ��� ������� ��ü�� �ּҰ��� �����ͼ� �̿�
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1 :%s\n", t1);
		
		TestBean t2 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t2 :%s\n", t2);
		ctx.close();
	}
	 
	// ApplicationContext - ��Ű�� �ܺ�
		public static void test4() {
			FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
			// beans.xml �� ���ǵ� bean ��ü�� �ڵ� ���� O - ���� ����
			
			TestBean t1 = ctx.getBean("t2", TestBean.class);
			System.out.printf("t1 :%s\n", t1);
			
			TestBean t2 = ctx.getBean("t2", TestBean.class);
			System.out.printf("t2 :%s\n", t2);
			ctx.close();
		}
}