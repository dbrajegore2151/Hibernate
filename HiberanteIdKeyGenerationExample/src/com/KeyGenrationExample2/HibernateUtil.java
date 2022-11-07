package com.KeyGenrationExample2;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static StandardServiceRegistry registry = null;

	private static SessionFactory sf = null;

	public static SessionFactory getsSessionFactory() {

		if (sf == null) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatejavabaseidGeneration2");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.HBM2DDL_AUTO, "update");

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources msd = new MetadataSources(registry).addAnnotatedClass(Employee.class);

			Metadata md = msd.getMetadataBuilder().build();

			sf = md.buildSessionFactory();

		}

		return sf;
	}
}