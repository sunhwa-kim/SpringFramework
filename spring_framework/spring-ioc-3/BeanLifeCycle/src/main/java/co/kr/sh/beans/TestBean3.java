package co.kr.sh.beans;

public class TestBean3 {
	
	public TestBean3() {
		System.out.println("> TestBean3 생성자");
	}
	
	public void default_init() {
		System.out.println("> TestBean3 - default_init");
	}
	
	public void default_destroy() {
		System.out.println("> TestBean3 - default_destroy");
	}
	
	public void bean3_init() {
		System.out.println("> TestBean3 - init 메서드");
	}
	
	public void bean3_destroy() {
		System.out.println("> TestBean3 - destroy 메서드");
	}
}
