package com.Admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.FileInfo;
import com.Util.HibernateUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
		SessionFactory sf = HibernateUtil.geSessionFactory();
		
		Session session = sf.openSession();
		
		FileInfo fileInfo = new FileInfo();
		
		File file = new File("C:\\Users\\Vozon\\FileHandling\\output.data");
		
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		Path path = Paths.get(file.getAbsolutePath());
		
		byte [] b = Files.readAllBytes(path);
		
		System.out.println(Arrays.toString(b));
	
		fileInfo.setFname(file.getAbsolutePath());
		fileInfo.setFdata(b);
		fileInfo.setFsize(file.length());
		  
		Date date = new Date(System.currentTimeMillis());
		
		SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/MM/yyyy hh:mm:sss");
		
		String strDate = dateFormat.format(date);
		
		fileInfo.setFileUploadDate(strDate);
		
		session.save(fileInfo);
		session.beginTransaction().commit();
	
	
	
	}
	
	
	
}
