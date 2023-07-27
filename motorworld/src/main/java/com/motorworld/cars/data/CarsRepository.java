package com.motorworld.cars.data;

import org.springframework.data.repository.CrudRepository;

import com.motorworld.cars.model.Car;

public interface CarsRepository extends CrudRepository<Car, Integer>
{

}
