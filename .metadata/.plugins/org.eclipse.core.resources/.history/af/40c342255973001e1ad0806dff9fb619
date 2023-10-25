package com.jdc.weekend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String  name;
	@Column(nullable = false)
	private int duration;
	@Column(nullable = false)
	private int fees;
	
	public Course(String name, int duration, int fees) {
		super();
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}
	
	
	
}
