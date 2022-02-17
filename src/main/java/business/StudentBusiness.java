package business;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.StudentDao;
import model.AssessmentReport;
import model.Course;
import model.Enrollment;
import model.Student;

@Component
public class StudentBusiness {
	@Autowired
	private StudentDao studentDao;
	
	public int register(Student student) {
		return studentDao.insertStudent(student);
	}
	public Student login(String email, String password) {
		return studentDao.readStudent(email,password);
	}
	public int enrollCourse(Student student,int courseId) {
		int result=-1;
		Course course=studentDao.readCourse(courseId);
		if(course!=null) {
			Enrollment enrollment=new Enrollment();
			enrollment.setStudent(student);
			enrollment.setCourse(course);
			enrollment.setEnrollmentDate(Date.valueOf(LocalDate.now()));
			enrollment.setStatus("Active");
			result=studentDao.insertEnrollment(enrollment);
		}
		return result;
	}
	public List<Course> getCourseList(){
		return studentDao.readCourses();
	}
	public List<Enrollment> getEnrollmentList(int studentId) {
		return studentDao.readEnrolledCourses(studentId);
	}
	public List<AssessmentReport> getAssessmentReportList(int studentId) {
		return studentDao.readAssessmentReport(studentId);
	}
}
