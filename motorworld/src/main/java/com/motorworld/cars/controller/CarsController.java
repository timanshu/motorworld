package com.motorworld.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motorworld.cars.model.Car;
import com.motorworld.cars.service.CarsService;

@RestController
public class CarsController 
{
	@Autowired
	CarsService carService;
	
	@RequestMapping("/cars")
	public List<Car> getCars()
	{
		return carService.getAllCars();
	}	
	
	@RequestMapping("/cars/{id}")
	public Car getCar(@PathVariable int id)
	{
		return carService.getCar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/cars")
	public void saveCar(Car car)
	{
		carService.saveCar(car);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/cars/{id}")
	public void updateCar(@PathVariable int id, @RequestBody Car car)
	{
		carService.saveCar(car);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/cars/{id}")
	public void deleteCar(@PathVariable int id)
	{
		carService.deleteCar(id);
	}
}
