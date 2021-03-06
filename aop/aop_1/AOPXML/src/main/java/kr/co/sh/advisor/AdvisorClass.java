package kr.co.sh.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {

	public void beforeMethod() {
		System.out.println(" > before method 호출");
	}
	
	public void afterMethod() {
		System.out.println(" > after method 호출");
	}
	
	// 둘러싸기 - 해당 메서드의 전/후 경계 애매모호한 ...원래 메서드 호출
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(" >> arount method 호출 1");
		
		// 원래 메서드 호출
		Object obj = pjp.proceed();  // int로 하려면 객체 반환이라 (Integer)로 형변환
		
		System.out.println(" >> arount method 호출 2");
		return obj;
	}
	
	// 예외없이 정상 동작
	public void afterReturningMethod() {
		System.out.println(" >> after returning method 호출");
	}
	
	// 예외 발생시 호출 중단시
	public void afterThrowingMethod(Throwable exe) {
		System.out.println(" >> afterThrowingMethod 호출");
		System.out.println(exe);
	}
}
