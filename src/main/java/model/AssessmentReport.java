package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assessmentreport")
public class AssessmentReport {
	@Id @GeneratedValue @Column(name="ar_id")
	private int id;
	@Column(name="ar_date")
	private String date;
	@Column(name="ar_total_mark")
	private int totalMarks;
	@Column(name="ar_obtained_mark")
	private int obtainedMarks;
	@OneToOne
	private Assessment assessement;
	@OneToOne
	private Student student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public Assessment getAssessement() {
		return assessement;
	}
	public void setAssessement(Assessment assessement) {
		this.assessement = assessement;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
