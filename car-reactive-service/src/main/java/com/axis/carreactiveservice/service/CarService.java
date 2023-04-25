package com.axis.carreactiveservice.service;

import com.axis.carreactiveservice.entity.Car;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {
	// some methods to access DB
	Mono<Car> getCarByEngineNumber(long engineNumber);
	Flux<Car> getAllCars();
	void saveCar(Car car);
	void updateCar(long engineNumber, Car updatedCar);
	void deleteCarByEngineNumber(long engineNumber);

}
