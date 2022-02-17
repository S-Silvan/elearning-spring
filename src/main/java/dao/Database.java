package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Database {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			Configuration configuration=new Configuration();
			configuration.configure();
			sessionFactory=configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	public void finalize() {
		sessionFactory=null;
	}
}
