package com.Student;

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

import com.Util.HibernateUtil;

public class Test {

	public static void main(String[] args) throws IOException {

		SessionFactory sf = HibernateUtil.geSessionFactory();

		Session session = sf.openSession();

		OppsDocFile sfile = new OppsDocFile();

		File file = new File("D:\\JAVA\\Oops concepts.docx");

		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.length());

		Path path = Paths.get(file.getAbsolutePath());

		byte[] b = Files.readAllBytes(path);

		System.out.println(Arrays.toString(b));

		sfile.setSdata(b);
		sfile.setSname(file.getName());
		sfile.setSize(file.length());

		Date date = new Date(System.currentTimeMillis());

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String strDate = dateFormat.format(date);

		sfile.setUploadDate(strDate);

		session.save(sfile);
		session.beginTransaction().commit();

		System.out.println("success....");

	}

}
