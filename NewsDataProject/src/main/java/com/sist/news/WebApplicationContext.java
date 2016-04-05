package com.sist.news;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;
//5
public class WebApplicationContext {
	// 6==> FandlerMappomg(pack��ge) �����
	// FileConfig
	private List<String> list = new ArrayList<String>();
	public WebApplicationContext(String path) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			// �ļ���
			SAXParser sp = spf.newSAXParser();
			HandlerMapping hm = new HandlerMapping();
			// startElement ==> hm
			sp.parse(new File(path), hm);
			list = hm.list;
		} catch (Exception ex) {}
	}
	public List<String> getFileName() {
		List<String> packList = new ArrayList<String>();
		for(String pack:list) {									// com.sist.model
			List<String> fList = FileConfig.getFileData(pack);	// com.sist.model.NewsController
			for(String s:fList) {
				packList.add(s);
			}
		}
		return packList;	// com.sist.model.NewsController
	}
}