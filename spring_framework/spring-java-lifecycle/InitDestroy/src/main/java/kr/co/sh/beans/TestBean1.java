package kr.co.sh.beans;

public class TestBean1 {

	public TestBean1() {
		System.out.println(" > 1 �⺻ ������");
	}
	
	public void init() {
		System.out.println(" > 1 init-method");
	}
	
	public void destroy() {
		System.out.println(" > 1 destroy-method");
	}
}