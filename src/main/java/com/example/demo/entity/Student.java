package com.example.demo.entity;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String intake;
	private String section;
	
	
	public Student() {	
	}
	
	
	public Student(int studentId, String studentName, String studentIntake, String studentSection) {
		super();
		id = studentId;
		name = studentName;
		intake = studentIntake;
		section = studentSection;
	}
	
	
	@Override
	public String toString() {
		return "Student [StudentId=" + id + ", StudentName=" + name + ", StudentIntake=" + intake
				+ ", StudentSection=" + section + "]";
	}
	
	
	public int getStudentId() {
		return id;
	}
	
	
	public void setStudentId(int studentId) {
		id = studentId;
	}
	
	
	public String getStudentName() {
		return name;
	}
	
	
	public void setStudentName(String studentName) {
		name = studentName;
	}
	
	
	public String getStudentIntake() {
		return intake;
	}
	
	
	public void setStudentIntake(String studentIntake) {
		intake = studentIntake;
	}
	
	
	public String getStudentSection() {
		return section;
	}
	
	
	public void setStudentSection(String studentSection) {
		section = studentSection;
	}
}
