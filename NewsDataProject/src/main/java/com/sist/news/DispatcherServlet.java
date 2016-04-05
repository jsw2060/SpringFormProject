package com.sist.news;
//1
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
//2
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> clsList = new ArrayList<String>();
	// 3
	private WebApplicationContext wc;
	public void init(ServletConfig config) throws ServletException {
		// 4 => path ==> WebApplicationContext
		String path=config.getInitParameter("contextConfigLocation");
		wc = new WebApplicationContext(path);
		clsList = wc.getFileName();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cmd = request.getRequestURI();
			cmd	= cmd.substring(request.getContextPath().length()+1);
			// cmd = list.do
			for(String strCls:clsList) {							//clsList = com.sist.model.NewsController
				Class clsName = Class.forName(strCls);
				// class com.sist.model.NewsController
				if(clsName.isAnnotationPresent(Controller.class)==false)
					continue;	// ��Ʈ�ѷ���� ������̼��� ������, �޸� �Ҵ��� �ʿ䰡 ����. ���ܽ�Ų��.
				Object obj = clsName.newInstance();	// ��Ʈ�ѷ� ������̼��� ������, �޸� �Ҵ� �Ѵ�.
				//com.sist.model.NewsController@6ab537bf
				Method[] methods = clsName.getDeclaredMethods();
				for(Method m:methods) {
					RequestMapping rm = m.getAnnotation(RequestMapping.class);
					if(rm.value().equals(cmd)) {
						String jsp = (String)m.invoke(obj, request);
													// Ŭ������ �޼ҵ� ���� �ƹ����Գ� �ص� �ȴ�.
													// �ֳĸ� request mapping�� ���� �������� �Ŵϱ� fozo ���
						RequestDispatcher rd = request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						return;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("DispatcherServlet" + ex.getMessage());
		}
	}
}
