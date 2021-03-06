package kr.co.sh.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/sh/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1.data1 : %d\n",xml1.getData1());
		System.out.printf("xml1.data2 : %s\n",xml1.getData2());
		System.out.printf("xml1.data3 : %s\n",xml1.getData3());
		System.out.printf("xml1.data4 : %s\n",xml1.getData4());
		System.out.printf("xml1.data5 : %s\n",xml1.getData5());
		System.out.printf("xml1.data6 : %s\n",xml1.getData6());
		
		
		System.out.println("  ----------------------------- ");
		TestBean2 xml2 = ctx1.getBean("xml2",TestBean2.class);
		System.out.printf("xml2.data1 : %d\n", xml2.getData1());  // @Value("100") int data1 추가
		System.out.printf("xml2.data2 : %s\n", xml2.getData2());
		// 먼저 3,4 객체타입만의 자동주입 확인 :<context:annotation-config/> + 생성자 매개변수 타입만으로 자동주입
		System.out.printf("xml2.data3 : %s\n", xml2.getData3());   
		System.out.printf("xml2.data4 : %s\n", xml2.getData4());
		
		ctx1.close();
		
		System.out.println("  =========================================  ");
		
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 java1 = ctx.getBean("java1", TestBean1.class);
		System.out.printf("java1.data1 : %d\n",java1.getData1());
		System.out.printf("java1.data2 : %s\n",java1.getData2());  // 2=3 singleton
		System.out.printf("java1.data3 : %s\n",java1.getData3());
		System.out.printf("java1.data4 : %s\n",java1.getData4());  // 동일 bean
		System.out.printf("java1.data5 : %s\n",java1.getData5());
		System.out.printf("java1.data6 : %s\n",java1.getData6());  // null 확인 - 등록안된 bean @Autowired(false)
		
		System.out.println("  ---------------------------------  ");
		TestBean2 java2 = ctx.getBean("java2", TestBean2.class);
		System.out.printf("java2.data1 : %d\n", java2.getData1());
		System.out.printf("java2.data2 : %s\n", java2.getData2());
		System.out.printf("java2.data3 : %s\n", java2.getData3());
		System.out.printf("java2.data4 : %s\n", java2.getData4());
		
		
		ctx.close();
	}

}
