package com.reto2.microservices.apibikes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.reto2.microservices.apibikes.dto.BikeDTO;
import com.reto2.microservices.apibikes.dto.CreateBikeDTO;
import com.reto2.microservices.apibikes.model.Bike;
import com.reto2.microservices.apibikes.repository.BikesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikesService {
    @Autowired
    private BikesRepository bikesRepository;

    public List<BikeDTO> getAll(){
        try {
            List<BikeDTO> bikes = new ArrayList<>();
            for( Bike b : bikesRepository.findAll() ){
                bikes.add( new BikeDTO( b.getId(),
                                        b.getBrand(),
                                        b.getType(),
                                        b.getColor(),
                                        b.getState()
                                        ) );
            }
            return bikes;
        } catch (Exception e) {
            throw e;
        }
    }

    public BikeDTO getById(String id){ 
        try {
            Optional<Bike> bikeData = bikesRepository.findById(id);
            if (bikeData.isPresent()){
                Bike bike = bikeData.get();
                BikeDTO bikeDTO = new BikeDTO(
                    bike.getId(),
                    bike.getBrand(),
                    bike.getType(),
                    bike.getColor(),
                    bike.getState()
                );
                return bikeDTO;
            }else{
                return new BikeDTO();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public BikeDTO create(CreateBikeDTO newBike){
        try {
            Bike bike = bikesRepository.save(new Bike(
                newBike.getBrand(),
                newBike.getType(),
                newBike.getColor(),
                true
            ));
            BikeDTO bikeDTO = new BikeDTO(
                    bike.getId(),
                    bike.getBrand(),
                    bike.getType(),
                    bike.getColor(),
                    bike.getState()
            );
            return bikeDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<BikeDTO> getAvailableBikes(){
        try {
            List<BikeDTO> bikes = new ArrayList<>();
            for( Bike b : bikesRepository.findByState(true) ){
                bikes.add( new BikeDTO( b.getId(),
                                        b.getBrand(),
                                        b.getType(),
                                        b.getColor(),
                                        b.getState()
                                        ) );
            }
            return bikes;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<BikeDTO> getNotAvailableBikes(){
        try {
            List<BikeDTO> bikes = new ArrayList<>();
            for( Bike b : bikesRepository.findByState(false)){
                bikes.add( new BikeDTO( b.getId(),
                                        b.getBrand(),
                                        b.getType(),
                                        b.getColor(),
                                        b.getState()
                                        ) );
            }
            return bikes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(String id){
        try {
            bikesRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteAll(){
        try {
            bikesRepository.deleteAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public BikeDTO update(String id, CreateBikeDTO newBike){
        try {
            Optional<Bike> oldBikeData = bikesRepository.findById(id);
            if (oldBikeData.isPresent()){
                Bike bikeToUpdate = oldBikeData.get();
                bikeToUpdate.setBrand(newBike.getBrand());
                bikeToUpdate.setType(newBike.getColor());
                bikeToUpdate.setColor(newBike.getColor());
                Bike updatedBike = bikesRepository.save(bikeToUpdate);
                BikeDTO updatedBikeDTO = new BikeDTO(
                    updatedBike.getId(),
                    updatedBike.getBrand(),
                    updatedBike.getType(),
                    updatedBike.getColor(),
                    updatedBike.getState()
                );
                return updatedBikeDTO;
            }else{
                return new BikeDTO();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void updateState(String id, Boolean updated){
        try {
            Optional<Bike> oldBikeData = bikesRepository.findById(id);
            if (oldBikeData.isPresent()){
                Bike bikeToUpdate = oldBikeData.get();
                bikeToUpdate.setState(updated);
                Bike updatedBike = bikesRepository.save(bikeToUpdate);
                BikeDTO updatedBikeDTO = new BikeDTO(
                    updatedBike.getId(),
                    updatedBike.getBrand(),
                    updatedBike.getType(),
                    updatedBike.getColor(),
                    updatedBike.getState()
                );
                System.out.println("Bike updated");
            }else{
                System.out.println("Bike dont exist");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
