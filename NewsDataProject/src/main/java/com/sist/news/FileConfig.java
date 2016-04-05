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
			// pack�� �ִ� ��Ű�� ��ε� .�� \�� �ٲ㼭 �ٿ��ְ� �ȴ�
			// C:\webDev\webStudy\NewsDataProject\src\main\java\com\sist\model
			File dir = new File(path);
			File[] files = dir.listFiles();
			for(File f:files) {
				if(f.isFile()) {	// �ش� ������ �ִ��� ���θ� boolean������ ��ȯ
					String name = f.getName();
					String ext = name.substring(name.lastIndexOf('.')+1);
					// .properties��� Ȯ������ ������ �� ���� �־, .java Ȯ���ڸ� �̾Ƴ��� ����
					// ��Ű���� �̾Ƽ� �޸� �Ҵ� �ؾ��ϴϱ�.
					if(ext.equals("java")) {
						String java = pack + "." + name.substring(0, name.lastIndexOf('.'));	// NewsController
						// ���ϸ��� �ڹ� Ȯ���� �κ��� �߶󳻰�, �ڹ��� ���� �޸��Ҵ� �ؾ��ϹǷ�,
						// class�� Class.forName() �κп� �ִ´ٴ� ����
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