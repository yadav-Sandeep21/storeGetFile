package com.ty.file.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.file.util.ConnectionObject;

public class FileDao {
	
	public void getFile(String path, int id) {
		FileOutputStream fileOutputStream;
		String sql="SELECT * FROM file WHERE id=?";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {
				int rid=resultset.getInt(1);
				String name=resultset.getString(2);
				String fileName=resultset.getString(3);
				Blob blob=resultset.getBlob(4);
				
				byte[] array=blob.getBytes(1, (int)blob.length());
				
				fileOutputStream=new FileOutputStream(path);
				fileOutputStream.write(array);
				
				System.out.println("Done!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Save File
	public void saveFile(int id, String username, String fileName, FileInputStream fileInputStream) {
		String sql="INSERT INTO file VALUES(?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, username);
			preparedstatement.setString(3, fileName);
			preparedstatement.setBlob(4, fileInputStream);
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
