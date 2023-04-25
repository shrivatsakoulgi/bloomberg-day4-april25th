package com.axis.driverreactiveservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.axis.driverreactiveservice.entity.Car;
import com.axis.driverreactiveservice.entity.CarDriver;
import com.axis.driverreactiveservice.service.DriverService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	//@Value("${car-service-url}")
	private String carServiceUrl="http://localhost:8100/car";
	private WebClient webClient = WebClient.builder().baseUrl(carServiceUrl).build();
	
	// Connecting to Car Service
	// Asynchronous Micro Service call 	
	@GetMapping("/car")
	public Flux<Car> getAllCarsFromDriver(){
		Flux<Car> carFlux=webClient.get().uri("")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToFlux(Car.class);	
		return carFlux;

	}
	
	@GetMapping("/car/{engineNumber}")
	public Mono<Car> getCarByEngineNumberFromDriver(@PathVariable long engineNumber){
		Mono<Car> carMono = webClient.get().uri(carServiceUrl+"/"+engineNumber)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Car.class);
		return carMono;
	}
	
	@PostMapping("/car")
	public ResponseEntity<String> addCarFromDriver(@RequestBody Car car){
		webClient.post()
		.uri("")
		.body(Mono.just(car),Car.class)
		.exchange()
		.subscribe(clientResponse->System.out.println(clientResponse.statusCode()));
		
		return new ResponseEntity<String>("Car inserted from Driver with EngineNumber:"+car.getEngineNumber(),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public Flux<CarDriver> getAllDrivers(){
		return driverService.getAllCarDrivers();
	}
	
	@GetMapping("/{driverId}")
	public Mono<CarDriver> getDriverById(@PathVariable int driverId){
		return driverService.getCarDriverById(driverId);
	}
	
	@PostMapping
	public ResponseEntity<String> saveDriver(@RequestBody CarDriver driver){
		driverService.saveCarDriver(driver);
		return new ResponseEntity<String>("CarDriver saved with driverId:"+driver.getDriverId(),HttpStatus.CREATED);
	}
	
	

}
