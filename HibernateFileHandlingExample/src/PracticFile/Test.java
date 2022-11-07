package PracticFile;

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

		FilePractice filePractice = new FilePractice();

		File file = new File("D:\\JAVA KeyWords.txt");

		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		System.out.println("-----------------------------");
		System.out.println(file.getTotalSpace());
		System.out.println(file.getCanonicalPath());	
		
		System.out.println("-----------------------------");
		
		
		Path path = Paths.get(file.getAbsolutePath());

		byte[] b = Files.readAllBytes(path);

		System.out.println(Arrays.toString(b));

		filePractice.setFname(file.getAbsolutePath());
		filePractice.setFsize(file.length());
		filePractice.setBdata(b);

		Date date = new Date(System.currentTimeMillis());

		SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		String dstr = dateFormat.format(date);

		filePractice.setFileUploadDate(dstr);

		session.save(filePractice);
		session.beginTransaction().commit();
	}
}
