package com.axis.carreactiveservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.carreactiveservice.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{

	//?1 ?2 -> are positional parameters from the method
	@Modifying
	@Query("update Car set name=?1, fuelType=?2, engineCapacity=?3, mileage=?4 where engineNumber=?5")
	void updateCarInfo(String name, String fuelType,int engineCapacity,double mileage, long engineNumber);
}
