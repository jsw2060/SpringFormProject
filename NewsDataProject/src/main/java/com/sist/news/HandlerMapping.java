package com.sist.news;
// 7 => ÆÄ½Ì
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class HandlerMapping extends DefaultHandler{
	List<String> list = new ArrayList<String>();
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("context:component-scan")) {
				String pack=attributes.getValue("base-package");
				list.add(pack);		// pack = com.sist.model
			}
		} catch (Exception ex) {}
	}
	
}
