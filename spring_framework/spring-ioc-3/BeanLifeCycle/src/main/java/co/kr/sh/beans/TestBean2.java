package co.kr.sh.beans;

public class TestBean2 {

	public TestBean2() {
		System.out.println("> TestBean2 생성자");
	}
	
	public void default_init() {
		System.out.println("> TestBean2 - default_init");
	}
	
	public void default_destroy() {
		System.out.println("> TestBean2 - default_destroy");
	}
}
