package com.sist.news;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// SOURCE, CLASS, 		RUNTIME 얼마동안 저장하고 있을거야?
//	컴파일 후 자동으로 바로 해제 		프로그램 종료시까지 사용
@Target(ElementType.TYPE)
/*
 * 	ElementType.TYPE
 * 	ElementType.METHOD
 * 	ElementType.PARAMETER
 * 	ElementType.FIELD
 * 
 * 	@ -> TYPE 클래스 찾을떄
 * 	class A {
 * 		@ -> FIELD 멤버변수 찾을 떄
 * 		B b;
 * 		@ -> METHOD 메소드 찾을 때
 * 		public void display() {}
 * 		public A(@ -> PARAMETER 매개변수 찾을 떄  B b) {
 * 			
 * 		}
 * 	}
 * 
 * 	@Controller("")
 */
public @interface Controller {
	public String value();	// String 값 들어오는 거 보고 메소드 알아서 찾아와 (자동구현)
}
