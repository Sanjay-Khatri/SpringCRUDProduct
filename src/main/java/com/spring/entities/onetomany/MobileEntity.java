package com.spring.entities.onetomany;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mobile")
public class MobileEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int mobid;
	private String mobileNumber;
	
	

	public int getMobid() {
		return mobid;
	}

	public void setMobid(int mobid) {
		this.mobid = mobid;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Mobile [mobid=" + mobid + ", mobileNumber=" + mobileNumber + "]";
	}

}
