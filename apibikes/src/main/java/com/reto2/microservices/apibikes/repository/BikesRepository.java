package com.reto2.microservices.apibikes.repository;
import java.util.List;

import com.reto2.microservices.apibikes.model.Bike;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BikesRepository extends MongoRepository <Bike, String>{
    List<Bike> findByBrand(String brand);
    List<Bike> findByState(boolean state);
}
