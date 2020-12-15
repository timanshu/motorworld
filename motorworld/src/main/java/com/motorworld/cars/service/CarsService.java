package com.motorworld.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.motorworld.cars.data.CarsRepository;
import com.motorworld.cars.exception.CarNotFoundException;
import com.motorworld.cars.model.Car;

@Service
public class CarsService 
{
	@Autowired
	private CarsRepository carsRepo;
	
	/**
	 * This method returns all instances of cars in the system
	 * 
	 * @return
	 */
	public List<Car> getAllCars()
	{
		List<Car> cars = new ArrayList<>();
		carsRepo.findAll().forEach(car -> {
			cars.add(car);
		});

		return cars;
	}
	
	/**
	 * This method save instance of the car
	 * 
	 * @param car
	 * @return
	 */
	public int saveCar(Car car)
	{
		Car c = carsRepo.save(car);
		
		return c.getId();
	}
	
	/**
	 * This method is used to update an existing object of car
	 * @param id 
	 * @param car
	 * @return 
	 */
	public void updateCar(int id, Car car)
	{
		car.setId(id);
		if(carsRepo.existsById(id))
			carsRepo.save(car);
		else
		{
			throw new CarNotFoundException("Instance of Car with id " + id + " does not exist");
		}
	}
	
	
	/**
	 * Call this method to delete the instance of Car
	 * @param id
	 */
	public void deleteCar(int id)
	{
		carsRepo.deleteById(id);
	}

	/**
	 * This method is used to get an instance of Car
	 * 
	 * @param id
	 * @return
	 */
	public Car getCar(int id) 
	{
		return carsRepo.findById(id).get();
	}
}
