package com.axis.carreactiveservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.carreactiveservice.entity.Car;
import com.axis.carreactiveservice.service.CarService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/car")
public class CarAsynchController {

	@Autowired
	private CarService carService;
	
	@GetMapping
	public Flux<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping("/{engineNumber}")
	public Mono<Car> getCarByEngineNumber(@PathVariable long engineNumber){
		return carService.getCarByEngineNumber(engineNumber);
	}
	
	@PostMapping
	public ResponseEntity<String> saveCar(@RequestBody Car car){
		carService.saveCar(car);
		return new ResponseEntity<String>
		("Car inserted with EngineNumber:"+car.getEngineNumber(),HttpStatus.CREATED);
		
	}
}
