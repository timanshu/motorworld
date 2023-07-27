package com.motorworld.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.motorworld.bike.data.BikeRepository;
import com.motorworld.bike.exception.BikeNotFoundException;
import com.motorworld.bike.model.Bike;

@Service
public class BikeService 
{
	@Autowired
	private BikeRepository bikeRepo;
	
	/**
	 * This method returns all instances of bike in the system
	 * 
	 * @return
	 */
	public List<Bike> getAllBike()
	{
		List<Bike> bike = new ArrayList<>();
		bikeRepo.findAll().forEach(bike -> {
			bike.add(bike);
		});

		return bike;
	}
	
	/**
	 * This method save instance of the bike
	 * 
	 * @param bike
	 * @return
	 */
	public int saveBike(Bike bike)
	{
		Bike c = bikeRepo.save(bike);
		
		return c.getId();
	}
	
	/**
	 * This method is used to update an existing object of bike
	 * @param id 
	 * @param bike
	 * @return 
	 */
	public void updateBike(int id, Bike bike)
	{
		bike.setId(id);
		if(bikeRepo.existsById(id))
			bikeRepo.save(bike);
		else
		{
			throw new BikeNotFoundException("Instance of Bike with id " + id + " does not exist");
		}
	}
	
	
	/**
	 * Call this method to delete the instance of Bike
	 * @param id
	 */
	public void deleteBike(int id)
	{
		bikeRepo.deleteById(id);
	}

	/**
	 * This method is used to get an instance of Bike
	 * 
	 * @param id
	 * @return
	 */
	public Bike getBike(int id) 
	{
		return bikeRepo.findById(id).get();
	}
}
