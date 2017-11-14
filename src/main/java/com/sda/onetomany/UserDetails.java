package com.sda.onetomany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;


	@OneToMany(mappedBy="userDetails", cascade = CascadeType.ALL)
	private List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

	public List<Vehicle> getVehiclesList() {
		return vehiclesList;
	}

	public void setVehiclesList(List<Vehicle> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
