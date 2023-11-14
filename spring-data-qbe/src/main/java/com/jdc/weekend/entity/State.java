package com.jdc.weekend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,unique = true)
	private String name;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;
	@Column(nullable = false)
	private String capital;
	@Column(nullable = false)
	private String region;
	
	
	
	public State(String name, Type type, String capital, String region) {
		super();
		this.name = name;
		this.type = type;
		this.capital = capital;
		this.region = region;
	}



	public enum Type {
		State("State"),Region("Region"),Union("Union");

		 private String value;
		
		Type(String value) {
			this.value=value;
		}

		public String getValue() {
			return value;
		}

	}
	
}