package kr.co.sh.main;

import kr.co.sh.beans.HelloWorld;
import kr.co.sh.beans.HelloWorldEn;
import kr.co.sh.beans.HelloWorldKo;

public class MainClass {

	public static void main(String[] args) {
//		HelloWorldEn hello1 = new HelloWorldEn();
//		HelloWorldKo hello1 = new HelloWorldKo();
//		callMethod(hello1);
//		HelloWorld hello1 = new HelloWorldKo();
		
		HelloWorld hello1 = callEn();
		hello1.sayHello();
		
		callMethod(callKo());
		
		HelloWorldEn hello2 = new HelloWorldEn();
//		callMethod(hello2);
		hello2.sayHello();
	}
	
//	public static void callMethod(HelloWorldEn hello) {
//		public static void callMethod(HelloWorldKo hello) {
			public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
		
	public static HelloWorld callEn() {
		return new HelloWorldEn();
	}
	
	public static HelloWorld callKo() {
		return new HelloWorldKo();
	}

}
