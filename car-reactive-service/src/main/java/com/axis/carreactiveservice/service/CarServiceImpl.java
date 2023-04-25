package com.axis.carreactiveservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.axis.carreactiveservice.entity.Car;
import com.axis.carreactiveservice.repository.CarRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	/*
	 * @Autowired private TransactionTemplate transactionTemplate;
	 */
	
	
	@Override
	public Mono<Car> getCarByEngineNumber(long engineNumber) {	
		
		Mono<Car> carMono = Mono.justOrEmpty(carRepository.findById(engineNumber));
		return carMono;
	}

	@Override
	public Flux<Car> getAllCars() {	
		return Flux
				.defer(()->Flux.fromIterable(this.carRepository.findAll()));
	}

	@Override
	public void saveCar(Car car) {
			carRepository.save(car);
	}

	@Transactional
	@Override
	public void updateCar(long engineNumber, Car updatedCar) {
	
		
	}

	@Override
	public void deleteCarByEngineNumber(long engineNumber) {

	}
}
