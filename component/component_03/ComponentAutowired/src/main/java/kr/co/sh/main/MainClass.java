package kr.co.sh.main;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.sh.beans.TestBean1;
import kr.co.sh.beans.TestBean2;
import kr.co.sh.beans.TestBean3;
import kr.co.sh.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 t1 = ctx.getBean(TestBean1.class);
		System.out.printf("> t1.data1 : %s\n", t1.getData1());
		// 이름 통한 주입 @Qualifier("obj2")
		System.out.printf("> t1.data2 : %s\n", t1.getData2());
		// 이름 통한 주입 @Resource
		System.out.printf("> t1.data3 : %s\n", t1.getData3());
		// 설정 클래스 등록 통한 이름 주입
		System.out.printf("> t1.data4 : %s\n", t1.getData4());
		System.out.printf("> t1.data5 : %s\n", t1.getData5());
		
		System.out.println(" ============================================ ");
		
		// 생성자 주입
		TestBean2 t2 = ctx.getBean(TestBean2.class);
		System.out.printf("> t2.data1 : %d\n", t2.getData1());
		System.out.printf("> t2.data2 : %s\n", t2.getData2());
		System.out.printf("> t2.data3 : %s\n", t2.getData3());
		System.out.printf("> t2.data4 : %s\n", t2.getData4());
		
		System.out.println(" -------------------------------------------- ");
		
//		TestBean3 java2 = ctx.getBean(TestBean3.class);  // 이름 부여시엔 하나만 있어도 이름으로 불러야 하나봐
		TestBean3 java2 = ctx.getBean("java2",TestBean3.class);
		System.out.printf("> java2.data1 : %d\n", java2.getData1());
		System.out.printf("> java2.data2 : %s\n", java2.getData2());
		System.out.printf("> java2.data3 : %s\n", java2.getData3());
		System.out.printf("> java2.data4 : %s\n", java2.getData4());
		
		
		ctx.close();

	}

}
