package com.axis.driverreactiveservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.driverreactiveservice.entity.CarDriver;
import com.axis.driverreactiveservice.repository.DriverRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepository driverRepository;
	@Override
	public Mono<CarDriver> getCarDriverById(int driverId) {
		Mono<CarDriver> driverMono = Mono.justOrEmpty(driverRepository.findById(driverId));
		return driverMono;
	}

	@Override
	public Flux<CarDriver> getAllCarDrivers() {
	
		Flux<CarDriver> driverFlux = Flux.defer(()->Flux.fromIterable(this.driverRepository.findAll()));
		return driverFlux;
	}

	@Override
	public void saveCarDriver(CarDriver driver) {
		
		driverRepository.save(driver);
		
	}

}
