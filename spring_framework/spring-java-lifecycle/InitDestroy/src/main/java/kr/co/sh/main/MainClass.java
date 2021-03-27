package kr.co.sh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1 : %s\n", xml1);
		
		ctx1.close();
		
		System.out.println(" ========== ============ =========== =============");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 t1 = ctx.getBean("java1", TestBean1.class);
		System.out.printf("t1 : %s\n", t1);
		
		ctx.close();
	}

}
