package com.motorworld.cars.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motorworld.cars.model.Car;

@Repository
public interface CarsRepository extends CrudRepository<Car, Integer>
{

}
