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

import com.motorworld.cars.model.Bike;
import com.motorworld.cars.service.BikeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class BikeController 
{
	@Autowired
	BikeService bikeService;
	
	/**
	 * This method returns all bike in the database
	 * 
	 * @return
	 */
	@Operation(
            summary = "Get instances of bike",
            description = "The method gets all the bike in the database")
	@RequestMapping(method = RequestMethod.GET, path = "/bike")
	public List<Bike> getBike()
	{
		return bikeService.getAllBike();
	}	
	
	/**
	 * The method is used to fetch a single bike instance on the basis of id
	 * 
	 * @param id
	 * @return
	 */
	@Operation(
            summary = "Get instances of bike with {id}",
            description = "This method will return a single instance of Bike. Passing id is mandatory")
	@RequestMapping(method = RequestMethod.GET, path = "/bike/{id}")
	public Bike getBike(@PathVariable int id)
	{
		return bikeService.getBike(id);
	}
	
	/**
	 * This method created a new instance of bike
	 * 
	 * @param bike
	 */
	@Operation(
            summary = "Create a new instance of Bike",
            description = "A new bike instance will be created. No need to pass id with the bike instance as it will be auto generated.")
	@PostMapping("/bike")
	public int saveBike(@RequestBody @NonNull Bike bike)
	{
		return bikeService.saveBike(bike);
	}
	
	/**
	 * This method updates an existing object of Bike in the database
	 * 
	 * @param id
	 * @param bike
	 */
	@Operation(
            summary = "Alter an existing instance!",
            description = "An existing bike instance will be modified. Passing id is mandatory.")
	
	@RequestMapping(method=RequestMethod.PUT, value="/bike/{id}")
	public void updateBike(@PathVariable int id, @RequestBody @NonNull Bike bike)
	{
		bikeService.updateBike(id, bike);
	}
	
	/**
	 * This method deletes an instance of bike
	 * 
	 * @param id
	 */
	@Operation(
            summary = "Permanently delete an instance of bike",
            description = "Only id of an object needs to be passed and the instance will vanish from the database.")
	@RequestMapping(method=RequestMethod.DELETE, value="/bike/{id}")
	public void deleteBike(@PathVariable int id)
	{
		bikeService.deleteBike(id);
	}
}
