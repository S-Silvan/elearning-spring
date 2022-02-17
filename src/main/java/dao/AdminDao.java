package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import model.AssessmentReport;
import model.Course;
import model.Student;
import model.Admin;

public class AdminDao {

	@Autowired
	private Admin admin;
	private SessionFactory sessionFactory;

	public AdminDao() {
		sessionFactory=Database.getSessionFactory();
	}

	public boolean login() {
		boolean isLogin=false;
		System.out.println("Amin login");
		Session session = sessionFactory.openSession();
		String SQL_QUERY =" select * from Admin where userName=? and Password=? ";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,admin.getName());
		query.setParameter(1,admin.getPassword());
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			isLogin= true;
		}
		session.close();
		return isLogin;   
	}

}


