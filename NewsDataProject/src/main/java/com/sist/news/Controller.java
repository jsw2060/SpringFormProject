package com.sist.news;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// SOURCE, CLASS, 		RUNTIME �󸶵��� �����ϰ� �����ž�?
//	������ �� �ڵ����� �ٷ� ���� 		���α׷� ����ñ��� ���
@Target(ElementType.TYPE)
/*
 * 	ElementType.TYPE
 * 	ElementType.METHOD
 * 	ElementType.PARAMETER
 * 	ElementType.FIELD
 * 
 * 	@ -> TYPE Ŭ���� ã����
 * 	class A {
 * 		@ -> FIELD ������� ã�� ��
 * 		B b;
 * 		@ -> METHOD �޼ҵ� ã�� ��
 * 		public void display() {}
 * 		public A(@ -> PARAMETER �Ű����� ã�� ��  B b) {
 * 			
 * 		}
 * 	}
 * 
 * 	@Controller("")
 */
public @interface Controller {
	public String value();	// String �� ������ �� ���� �޼ҵ� �˾Ƽ� ã�ƿ� (�ڵ�����)
}
