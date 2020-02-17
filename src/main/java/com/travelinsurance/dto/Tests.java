package com.travelinsurance.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tests {
	
	@Id
	private String twoId;
	private String name;
	
	@ManyToOne
	private Test test;

	public String getTwoId() {
		return twoId;
	}

	public void setTwoId(String twoId) {
		this.twoId = twoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	

}
