package com.sist.news;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//SOURCE, CLASS, 		RUNTIME �󸶵��� �����ϰ� �����ž�?
//	������ �� �ڵ����� �ٷ� ���� 		���α׷� ����ñ��� ���
@Target(ElementType.METHOD)

public @interface RequestMapping {
	public String value();
}
