package com.sist.news;
import java.io.*;
import java.util.*;
public class FileConfig {
	public static List<String> getFileData(String pack) {
		List<String> list = new ArrayList<String>();
		try {
			String path="C:\\webDev\\webStudy\\NewsDataProject\\src\\main\\java\\";
			// pack = com.sist.model
			path = path + pack.replace('.', '\\');
			// pack에 있던 패키지 경로도 .을 \로 바꿔서 붙여주게 된다
			// C:\webDev\webStudy\NewsDataProject\src\main\java\com\sist\model
			File dir = new File(path);
			File[] files = dir.listFiles();
			for(File f:files) {
				if(f.isFile()) {	// 해당 파일이 있는지 여부를 boolean값으로 반환
					String name = f.getName();
					String ext = name.substring(name.lastIndexOf('.')+1);
					// .properties라는 확장자의 파일이 들어갈 수도 있어서, .java 확장자만 뽑아내기 위함
					// 팩키지만 뽑아서 메모리 할당 해야하니까.
					if(ext.equals("java")) {
						String java = pack + "." + name.substring(0, name.lastIndexOf('.'));	// NewsController
						// 파일명에서 자바 확장자 부분은 잘라내고, 자바의 경우는 메모리할당 해야하므로,
						// class명만 Class.forName() 부분에 넣는다는 개념
						// com.sist.model.NewsController
						list.add(java);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("FileConfig" + ex.getMessage());
		}
		return list;
	}
}