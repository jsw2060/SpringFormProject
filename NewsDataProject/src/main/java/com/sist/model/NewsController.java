package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.news.RequestMapping;

import com.sist.news.Controller;

// DAO,DTO,Model (Model)
@Controller("news")	// id = "news" �� ����	Hashmap�� Ŭ������ ������ ������� ���� ��ĺ��ٴ�
					// �� Ŭ���� �ȿ� �������� �޼ҵ� ���·� �������ִ� ���� �ξ� �����ϱ� ����.
public class NewsController {
	@RequestMapping("list.do")		// ����ڰ� list.do�� �Է��ϸ�, �ش� �޼ҵ带 ������ �����ض�.
	public String newsListData(HttpServletRequest request) {
		request.setAttribute("title", "���� ���");
		return "view/list.jsp";
	}
}