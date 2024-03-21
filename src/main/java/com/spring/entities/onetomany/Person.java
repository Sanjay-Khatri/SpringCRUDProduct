package com.spring.entities.onetomany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int personid;
	private String name;

	@OneToMany(targetEntity=MobileEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name="cp_fk", referencedColumnName="id")
	private List<MobileEntity> mobile;

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MobileEntity> getMobile() {
		return mobile;
	}

	public void setMobile(List<MobileEntity> mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Person [personid=" + personid + ", name=" + name + ", mobile=" + mobile + "]";
	}

	public void add(MobileEntity m) {
		this.mobile.add(m);
	}	
	
}
