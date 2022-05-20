package com.ty.file.Controller;

import com.ty.file.Dao.FileDao;

public class TestGetFile {

	public static void main(String[] args) {
		FileDao dao=new FileDao();
		dao.getFile("D:/download.jpg",1);
		
	}

}
