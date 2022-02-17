package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lesson")
public class Lesson {
@Column(name="le_chapter")
private int chapter;
@Column(name="le_title")
private String title;
@Column(name="le_description")
private String description;
@Column(name="le_Duration")
private double Duration;

public double getDuration() {
	return Duration;
}
public void setDuration(double duration) {
	Duration = duration;
}
public int getChapter() {
	return chapter;
}
public void setChapter(int chapter) {
	this.chapter = chapter;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}



}
