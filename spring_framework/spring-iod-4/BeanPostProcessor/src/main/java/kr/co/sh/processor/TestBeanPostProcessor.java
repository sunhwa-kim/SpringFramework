package kr.co.sh.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor{

	// init-method 호출 전
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" > before");
		
		// id 별 적용 - 1.7 이상
		switch(beanName) {
		case "t1":
			System.out.println(">> id=t1, bean 생성");
			break;
//		case "t2":
//			System.out.println(">> id=t2, bean 생성");
//			break;
		}
		return bean;
	}
	
	// init-method 호출 후
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" > after");
		return bean;
	}
}
