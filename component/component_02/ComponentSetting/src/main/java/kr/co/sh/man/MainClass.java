package kr.co.sh.man;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.beans.TestBean3;
import kr.co.sh.beans.TestBean4;
import kr.co.sh.beans.TestBean5;
import kr.co.sh.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 t1 = ctx.getBean(TestBean1.class);
		System.out.printf("t1 : %s\n", t1);
		TestBean1 t2 = ctx.getBean(TestBean1.class);
		System.out.printf("t2 : %s\n", t2);  // singleton
		
		System.out.println("-------------------------------------");
		// 형변환 때문에 클래스 타입 작성 -> 주로, Component시 같은 클래스 여러개 못 만드므로 클래스 타입으로 빈객체 가져온다.
		TestBean2 t3 = ctx.getBean("t3", TestBean2.class);
		System.out.printf("t3 : %s\n",t3);
		TestBean2 t4 = ctx.getBean("t3", TestBean2.class);
		System.out.printf("t4 : %s\n",t4);  // singleton
		
		System.out.println("-------------------------------------");
		TestBean2 t5 = ctx.getBean("t5", TestBean2.class);
		System.out.printf("t5 : %s\n",t5);
		TestBean2 t6 = ctx.getBean("t6", TestBean2.class);
		System.out.printf("t6 : %s\n",t6);  // no singleton
		
		System.out.println("-------------------------------------");
		// @Lazy
		TestBean3 t7 = ctx.getBean(TestBean3.class);
		System.out.printf("t7 : %s\n", t7);
		TestBean3 t8 = ctx.getBean(TestBean3.class);
		System.out.printf("t8 : %s\n", t8);  // singleton
		
		System.out.println("-------------------------------------");
		// @Scope
		TestBean4 t9 =ctx.getBean(TestBean4.class);
		System.out.printf("t9 : %s\n", t9);
		TestBean4 t10 =ctx.getBean(TestBean4.class);
		System.out.printf("t10 : %s\n", t10);  // no singleton
		
		System.out.println("-------------------------------------");
		// @PostConstruct, @PreDestroy
		TestBean5 t11 = ctx.getBean(TestBean5.class);
		System.out.printf("t11 : %s\n", t11);
		
		System.out.printf("");
		
		ctx.close();
	}
}
