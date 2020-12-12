package com.motorworld.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorworld.cars.data.CarsRepository;
import com.motorworld.cars.model.Car;

@Service
public class CarsService 
{
	@Autowired
	private CarsRepository carsRepo;
	
	public List<Car> getAllCars()
	{
		List<Car> cars = new ArrayList<>();
		carsRepo.findAll().forEach(car -> {
			cars.add(car);
		});
		
		/*
		 * Car c = new Car();
		 * 
		 * c.setId(1); c.setName("Audi"); cars.add(c);
		 */
		
		return cars;
	}
	
	public int saveCar(Car car)
	{
		Car c = carsRepo.save(car);
		
		return c.getId();
	}
	
	public void updateCar(Car c)
	{
		carsRepo.save(c);
	}
	
	public void deleteCar(int id)
	{
		carsRepo.deleteById(id);
	}

	public Car getCar(int id) 
	{
		return carsRepo.findById(id).get();
	}
}
