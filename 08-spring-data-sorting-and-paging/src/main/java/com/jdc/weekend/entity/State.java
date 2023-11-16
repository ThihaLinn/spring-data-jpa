package com.jdc.weekend.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	@Column(nullable = false,unique = true)
	private String name;
	
	@NonNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	
	private Type type;
	@Column(nullable = false)
	
	@NonNull
	private String capital;
	@Column(nullable = false)
	private String region;
	
	@OneToMany(mappedBy = "state",orphanRemoval = true)
	private List<District> district;
	
	
	
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



	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", type=" + type + ", capital=" + capital + ", region=" + region
				+ "]";
	}
	
}