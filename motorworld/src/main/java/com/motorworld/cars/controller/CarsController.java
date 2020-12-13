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

/***
 * This controller is responsible for managing the calls related to cars
 * 
 */
@RestController
public class CarsController 
{
	@Autowired
	CarsService carService;
	
	/**
	 * This method returns all cars in the database
	 * 
	 * @return
	 */
	@RequestMapping("/cars")
	public List<Car> getCars()
	{
		return carService.getAllCars();
	}	
	
	/**
	 * The method is used to fetch a single car instance on the basis of id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/cars/{id}")
	public Car getCar(@PathVariable int id)
	{
		return carService.getCar(id);
	}
	
	/**
	 * This method created a new instance of car
	 * 
	 * @param car
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/cars")
	public void saveCar(@RequestBody Car car)
	{
		carService.saveCar(car);
	}
	
	/**
	 * This method updates an existing object of Car in the database
	 * 
	 * @param id
	 * @param car
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/cars/{id}")
	public void updateCar(@PathVariable int id, @RequestBody Car car)
	{
		carService.saveCar(car);
	}
	
	/**
	 * This method deletes an instance of cars
	 * 
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/cars/{id}")
	public void deleteCar(@PathVariable int id)
	{
		carService.deleteCar(id);
	}
}
