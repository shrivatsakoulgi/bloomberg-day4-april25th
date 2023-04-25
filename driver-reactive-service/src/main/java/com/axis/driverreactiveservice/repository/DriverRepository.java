package com.axis.driverreactiveservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.driverreactiveservice.entity.CarDriver;

@Repository
public interface DriverRepository extends CrudRepository<CarDriver, Integer>{

}
