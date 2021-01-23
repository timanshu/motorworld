package com.motorworld.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motorworld.cars.model.Car;
import com.motorworld.cars.service.CarsService;

import io.swagger.v3.oas.annotations.Operation;

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
	@Operation(
            summary = "Get instances of cars",
            description = "The method gets all the cars in the database")
	@RequestMapping(method = RequestMethod.GET, path = "/cars")
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
	@Operation(
            summary = "Get instances of cars with {id}",
            description = "This method will return a single instance of Car. Passing id is mandatory")
	@RequestMapping(method = RequestMethod.GET, path = "/cars/{id}")
	public Car getCar(@PathVariable int id)
	{
		return carService.getCar(id);
	}
	
	/**
	 * This method created a new instance of car
	 * 
	 * @param car
	 */
	@Operation(
            summary = "Create a new instance of Car",
            description = "A new car instance will be created. No need to pass id with the car instance as it will be auto generated.")
	@PostMapping("/cars")
	public int saveCar(@RequestBody @NonNull Car car)
	{
		return carService.saveCar(car);
	}
	
	/**
	 * This method updates an existing object of Car in the database
	 * 
	 * @param id
	 * @param car
	 */
	@Operation(
            summary = "Alter an existing instance!",
            description = "An existing car instance will be modified. Passing id is mandatory.")
	
	@RequestMapping(method=RequestMethod.PUT, value="/cars/{id}")
	public void updateCar(@PathVariable int id, @RequestBody @NonNull Car car)
	{
		carService.updateCar(id, car);
	}
	
	/**
	 * This method deletes an instance of cars
	 * 
	 * @param id
	 */
	@Operation(
            summary = "Permanently delete an instance of car",
            description = "Only id of an object needs to be passed and the instance will vanish from the database.")
	@RequestMapping(method=RequestMethod.DELETE, value="/cars/{id}")
	public void deleteCar(@PathVariable int id)
	{
		carService.deleteCar(id);
	}
}
