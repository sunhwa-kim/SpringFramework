package kr.co.sh.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.beans.TestBean3;
import kr.co.sh.beans.TestBean4;
import kr.co.sh.config.BeanConfigClass;

public class ManClass {

	public static void main(String[] args) {
		
		// xml
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1 : %s\n", xml1);
		
		TestBean1 xml11 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml11 : %s\n", xml11);  // singleton
		
		System.out.println(" ----------------  -----------------  ---------------- ");
		
		TestBean2 xml2 = ctx1.getBean("xml2", TestBean2.class);  // lazt-init, sigleton
		System.out.printf("xml2 : %s\n", xml2);
		
		TestBean2 xml22 = ctx1.getBean("xml2", TestBean2.class);
		System.out.printf("xml22 : %s\n", xml22);
		
		System.out.println(" ----------------  -----------------  ---------------- ");
		
		TestBean3 xml3 = ctx1.getBean("xml3", TestBean3.class);
		System.out.printf("xml3 : %s\n", xml3);
		TestBean3 xml33 = ctx1.getBean("xml3", TestBean3.class);  // scope=prototype -> no singleton
		System.out.printf("xml33 : %s\n", xml33);
		
		System.out.println(" ----------------  -----------------  ---------------- ");
		
		// 클래스 타입이 한개만 있으면 id 사용 안해도 된다.
		// id 없이 클래스 타입이 중복 된다면 primary 통해 에러 없어진다.
		TestBean4 xml4 = ctx1.getBean(TestBean4.class);  // primary="true"
		System.out.printf("xml4 : %s\n", xml4);
		
		
		ctx1.close();
		
		System.out.println("  ===  ===  ===  ===  ===  ===  ===  ===  ===");
		
		// java file
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		TestBean1 java1 = ctx.getBean("java1", TestBean1.class);  // 생성자 메서드명
		System.out.printf("java1 : %s\n", java1);
		
		TestBean1 java11 = ctx.getBean("java1", TestBean1.class);
		System.out.printf("java11 : %s\n", java11);   //  singleton
		
		TestBean1 java500 = ctx.getBean("java600", TestBean1.class);  // @Bean(name) > 메서드명
		System.out.printf("java600 : %s\n", java500);

		System.out.println("  --------------------------------------------  ");
		
		TestBean2 java2 = ctx.getBean("java2", TestBean2.class);   // @Bean @Lazy , singleton
		System.out.printf("java2 : %s\n", java2);

		System.out.println("  --------------------------------------------  ");
		
		TestBean3 java3 = ctx.getBean("java3", TestBean3.class);   // @Bean @Scope , no singleton
		System.out.printf("java3 : %s\n", java3);
		TestBean3 java33 = ctx.getBean("java3", TestBean3.class);   // no singleton
		System.out.printf("java33 : %s\n", java33);

		
		System.out.println("  --------------------------------------------  ");
		
		TestBean4 java4 = ctx.getBean(TestBean4.class);
		System.out.printf("java4 : %s\n",java4);
	
		ctx.close();
	}

}
