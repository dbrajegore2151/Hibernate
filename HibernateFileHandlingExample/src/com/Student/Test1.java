package com.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;

public class Test1 {

	public static void main(String[] args) throws IOException {

		SessionFactory sf = HibernateUtil.geSessionFactory();

		Session session = sf.openSession();

		String newPath = "E:\\";

		OppsDocFile docFile = session.get(OppsDocFile.class, 1);
		System.out.println(docFile);

		File file = new File(docFile.getSname());

		Path path = Paths.get(newPath + docFile.getSname());

		Files.write(path, docFile.getSdata());

	}
}
