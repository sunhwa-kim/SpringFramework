package co.kr.sh.beans;

public class TestBean1 {

	public TestBean1() {
		System.out.println("> TestBean 1 생성자");
	}
	
	public void bean1_init() {
		System.out.println("> TestBean1 - init 메서드");
	}
	
	public void bean1_destroy() {
		System.out.println("> TestBean1 - destroy 메서드");
	}
}
