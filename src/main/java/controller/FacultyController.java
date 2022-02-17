package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.StudentDao;
import dao.FacultyDao;

@RestController
@RequestMapping(path="/faculty")
public class FacultyController {
	
	@GetMapping("/login")
	public String login() {
		return "Faculty_Login";
	}
	
	@GetMapping("/page")
	public String facultyPage() {
		return "Faculty_Page";
	}
	@GetMapping("/displayCourses")
	public String displayCourses() {
		return "display_courses";
	}
	@GetMapping("/addCourses")
	public String addCourses() {
		return "add_courses";
	}
	@GetMapping("/editCourses")
	public String editCourses() {
		return "edit_Courses";
	}
	@GetMapping("/checkAssessmentReports")
	public String checkAssessmentReports() {
		return "check_assessment_reports";
	}
	@GetMapping("/uploadAssessment")
	public String uploadAssessment() {
		return "upload_Assessment";
	}
	@GetMapping("/addQuestion")
	public String addQuestion(){
		return "add_Question";
	}
	@GetMapping("/displayStudents")
	public String displayStudents() {
		return "display_Students";
	}
	

}




