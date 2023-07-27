package com.motorworld.cars.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motorworld.bike.model.Bike;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Integer>
{

}
