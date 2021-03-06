package kr.co.sh.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.sh.beans.JdbcBean;
import kr.co.sh.config.BeanConfigClass;
import kr.co.sh.mapper.MapperInterface;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		MapperInterface mapper = ctx.getBean("testMapper", MapperInterface.class);
		
		// insert
//		JdbcBean bean1 = new JdbcBean();
//		bean1.setInt_data(100);
//		bean1.setStr_data("문자열100");
//		mapper.insert_data(bean1);
		
//		JdbcBean bean2 = new JdbcBean();
//		bean2.setInt_data(200);
//		bean2.setStr_data("문자열200");
//		mapper.insert_data(bean2);
		
		// update
//		JdbcBean bean3 = new JdbcBean();
//		bean3.setInt_data(100);
//		bean3.setStr_data("문자열 >> 수정");
//		mapper.update_data(bean3);
		
		// delete
		mapper.delete_data(100);
		
		// select
		List<JdbcBean> list1 = mapper.select_data();
		for(JdbcBean bean : list1) {
			System.out.printf("int_data : %d\n", bean.getInt_data());
			System.out.printf("str_data : %s\n", bean.getStr_data());
			System.out.println("--------------------------------------");
		}
		
		ctx.close();

	}

}
