package PracticFile;

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
		
		Session  session = sf.openSession();
		
		String newPath = "E:\\";
		
		
		FilePractice filePractice = session.get(FilePractice.class, 1);
		
		System.out.println(filePractice);
	
		File file = new File(filePractice.getFname());
		
		Path path = Paths.get(newPath+file.getName());
		
		Files.write(path,filePractice.getBdata());
		
	
	
	
	
	}
}
