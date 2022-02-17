package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.StudentBusiness;
import model.AssessmentReport;
import model.Course;
import model.Enrollment;
import model.Student;

@RestController
@RequestMapping(path="/student")
@Component
public class StudentController {
	Student student;
	@Autowired
	private StudentBusiness studentBusiness;
	
	@PostMapping("/register")
	public String register(@RequestBody Student student) {
		int insertId=studentBusiness.register(student);
		if(insertId>=0)
			return "Registration successful";
		else
			return "Registration unsuccessful";
	}
	@PostMapping("/login")
	public Student login(@RequestParam String email, @RequestParam String password) {
		student=studentBusiness.login(email, password);
		return student;
	}
	@PostMapping("/enrollCourse")
	public String enrollCourse(@RequestParam int courseId) {
		int insertId=studentBusiness.enrollCourse(student, courseId);
		if(insertId>=0)
			return "Course enrollment successful";
		else
			return "Course enrollment unsuccessful";
	}
	@GetMapping("/displayCourses")
	public List<Course> displayCourses() {
		return studentBusiness.getCourseList();
	}
	@GetMapping("/displayEnrolledCourses")
	public List<Enrollment> displayEnrolledCourses() {
		return studentBusiness.getEnrollmentList(student.getId());
	}
	@GetMapping("/displayAssessmentReports")
	public List<AssessmentReport> displayAssessmentReports() {
		return studentBusiness.getAssessmentReportList(student.getId());
	}
	@GetMapping("/doAssessment")
	public String doAssessment() {
		return "Do assessment";
	}
	@GetMapping("/submitAssessment")
	public String submitAssessment() {
		return "Submit assessment";
	}
}
