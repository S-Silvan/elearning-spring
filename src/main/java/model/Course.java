package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	@Id @GeneratedValue @Column(name="co_id")
	private int id;
	
	@Column(name="co_name")
	private String name;
	
	@Column(name="co_description")
	private String description;
	
	@Column(name="co_duration")
	private double Duration;
	
	@Column(name="co_price")
	private double price;
	
	@Column(name="co_resource")
	private String Resource;
	
	@OneToOne
	private Facutly faculty;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDuration() {
		return Duration;
	}

	public void setDuration(double duration) {
		Duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getResource() {
		return Resource;
	}

	public void setResource(String resource) {
		Resource = resource;
	}

	public Facutly getFaculty() {
		return faculty;
	}

	public void setFacultyId(Facutly faculty) {
		this.faculty = faculty;
	}
	
}
