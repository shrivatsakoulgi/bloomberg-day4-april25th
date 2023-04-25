package com.axis.driverreactiveservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	private long engineNumber;
	private String name;
	private String fuelType;	
	private int engineCapacity;
	private double mileage;	
	
	public Car() {
	}

	public Car(long engineNumber, String name, String fuelType, int engineCapacity, double mileage) {
		this.engineNumber = engineNumber;
		this.name = name;
		this.fuelType = fuelType;
		this.engineCapacity = engineCapacity;
		this.mileage = mileage;
	}

	public long getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(long engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [engineNumber=" + engineNumber + ", name=" + name + ", fuelType=" + fuelType + ", engineCapacity="
				+ engineCapacity + ", mileage=" + mileage + "]";
	}
	
	
	
	
	

}
