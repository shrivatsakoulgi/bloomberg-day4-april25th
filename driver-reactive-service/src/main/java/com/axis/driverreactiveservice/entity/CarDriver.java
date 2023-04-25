package com.axis.driverreactiveservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarDriver {

	@Id
	private int driverId;
	private String driverName;
	private int experience;
	private String route;
		
	public CarDriver() {
	}

	public CarDriver(int driverId, String driverName, int experience, String route) {
		this.driverId = driverId;
		this.driverName = driverName;
		this.experience = experience;
		this.route = route;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "CarDriver [driverId=" + driverId + ", driverName=" + driverName + ", experience=" + experience
				+ ", route=" + route + "]";
	}
	
	
	
}
