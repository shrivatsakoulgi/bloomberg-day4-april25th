package com.axis.driverreactiveservice.service;

import com.axis.driverreactiveservice.entity.CarDriver;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DriverService {

	public Mono<CarDriver> getCarDriverById(int driverId);
	public Flux<CarDriver> getAllCarDrivers();
	public void saveCarDriver(CarDriver driver);
}
