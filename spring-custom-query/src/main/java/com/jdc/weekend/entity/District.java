package com.jdc.weekend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "district")
@NamedQuery(name = "District.findByNameQuery",
			query = "select d from District d where d.state.id =:id and lower(d.name) like lower(:name)"
		)
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String name;
	@ManyToOne(optional = false)
	private State state;
	
}
