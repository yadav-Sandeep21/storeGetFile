package com.ty.file.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.ty.file.Dao.FileDao;


public class TestFile {

	public static void main(String[] args) {
		FileDao dao=new FileDao();

		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("D:/sandeep/batch6/download.jpg");
			dao.saveFile(1,"sandeep","download.jpg",fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
