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
import model.Student;
import model.Facutly;
import model.Question;
import model.Assessment;

@Component
public class FacultyDao {
private SessionFactory sessionFactory;
	
	public FacultyDao() {
		sessionFactory=Database.getSessionFactory();
	}
	
	
	 public List readStudent() {
		  List<Student> Students=null;
				
				Session session=sessionFactory.openSession();
				Query query=session.createQuery("FROM Students");
				Students=(List<Student>)query.list();
				session.close();
				return Students;
		}

	 public void addCourse( Course course)
	 {
		 Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(course);
			transaction.commit();
			session.close();
	 }
	
	 public void updateCourse(Course course) {
		 Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.update(course);
			transaction.commit();
			session.close();
	 }
	 
	public List readCourses() {
		List<Course> courses=null;
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Courses");
		courses=(List<Course>)query.list();
		session.close();
		
		return courses;
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
  public void addQuestion(Question question )
	 {
		 Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(question );
			transaction.commit();
			session.close();
	 }
	 
	 public void addAssessment( Assessment assessment )
	 {
		 Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(assessment);
			transaction.commit();
			session.close();
	 }
	

}
