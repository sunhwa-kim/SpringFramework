package kr.co.sh.main;

import kr.co.sh.beans.HelloWorld;
import kr.co.sh.beans.HelloWorldEn;
import kr.co.sh.beans.HelloWorldKo;

public class MainClass {

	public static void main(String[] args) {
		HelloWorld hello1 = new HelloWorldEn();  // 객체 생성 부분만 변경
		callMethod(hello1);
		
		HelloWorld hello2 = new HelloWorldKo();
		callMethod(hello2);
	}

	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
