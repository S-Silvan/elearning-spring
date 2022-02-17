package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import model.AssessmentReport;
import model.Course;
import model.Enrollment;
import model.Student;

@Component
public class StudentDao {
	private SessionFactory sessionFactory;
	
	public StudentDao() {
		sessionFactory=Database.getSessionFactory();
	}
	public int insertEnrollment(Enrollment enrollment) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		int result=(int)session.save(enrollment);
		transaction.commit();
		session.close();
		
		return result;
	}
	public int insertStudent(Student student) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		int result=(int)session.save(student);
		transaction.commit();
		session.close();
		
		return result;
	}
	public Student readStudent(String email, String password) {
		Student student=null;
		
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("email",email))
			.add(Restrictions.eq("password", password));
		List<Student> list=(List<Student>)criteria.list();
		if(list.size()>0)
			student=list.get(0);
		session.close();
		
		return student;
	}
	public Course readCourse(int courseId) {
		Course course=null;
		
		Session session=sessionFactory.openSession();
		session.get(Course.class, courseId);
		
		return course;
	}
	public List readCourses() {
		List<Course> courses=null;
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Courses");
		courses=(List<Course>)query.list();
		session.close();
		
		return courses;
	}
	public List readEnrolledCourses(int studentId) {
		List<Enrollment> enrolledCourses=null;
		
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Enrollment.class);
		criteria.add(Restrictions.eq("s_id",studentId));
		enrolledCourses=(List<Enrollment>)criteria.list();
		session.close();
		
		return enrolledCourses;
	}
	public List readAssessmentReport(int studentId) {
		List<AssessmentReport> assessmentReportList=null;
		
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(AssessmentReport.class);
		criteria.add(Restrictions.eq("s_id",studentId));
		assessmentReportList=(List<AssessmentReport>)criteria.list();
		session.close();
		
		return assessmentReportList;
	}
}
