package com.sist.news;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//SOURCE, CLASS, 		RUNTIME 얼마동안 저장하고 있을거야?
//	컴파일 후 자동으로 바로 해제 		프로그램 종료시까지 사용
@Target(ElementType.METHOD)

public @interface RequestMapping {
	public String value();
}
