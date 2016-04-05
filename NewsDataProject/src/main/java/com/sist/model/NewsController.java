package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.news.RequestMapping;

import com.sist.news.Controller;

// DAO,DTO,Model (Model)
@Controller("news")	// id = "news" 로 쓸게	Hashmap에 클래스를 여러개 만들었던 기존 방식보다는
					// 한 클래스 안에 여러개의 메소드 형태로 변경해주는 것이 훨씬 관리하기 좋다.
public class NewsController {
	@RequestMapping("list.do")		// 사용자가 list.do를 입력하면, 해당 메소드를 가져와 수행해라.
	public String newsListData(HttpServletRequest request) {
		request.setAttribute("title", "뉴스 목록");
		return "view/list.jsp";
	}
}