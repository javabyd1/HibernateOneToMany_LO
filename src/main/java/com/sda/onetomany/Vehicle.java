package com.sda.onetomany;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
