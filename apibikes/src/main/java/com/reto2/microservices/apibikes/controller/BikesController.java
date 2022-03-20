package com.reto2.microservices.apibikes.controller;

import java.util.List;

import com.reto2.microservices.apibikes.dto.BikeDTO;
import com.reto2.microservices.apibikes.dto.CreateBikeDTO;
import com.reto2.microservices.apibikes.services.BikesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BikesController {

    private final BikesService bikesService;

    @GetMapping("/bikes")
    public ResponseEntity<List<BikeDTO>> retrieveBikes(){
        try {
            List<BikeDTO> bikes = bikesService.getAll();
            return new ResponseEntity<>(bikes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    @GetMapping("/bikes/{id}")
    public ResponseEntity<BikeDTO> getBikeById(@PathVariable("id") String id) {
        try {
            BikeDTO bike = bikesService.getById(id);
            return new ResponseEntity<>(bike, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    @PostMapping("/bikes")
    public ResponseEntity<BikeDTO> createBike(@RequestBody CreateBikeDTO newBike) {
        try {
            BikeDTO bike = bikesService.create(newBike);
            return new ResponseEntity<>(bike, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error creating");
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/bikes/{id}")
    public ResponseEntity<BikeDTO> updateBike(@PathVariable("id") String id, @RequestBody CreateBikeDTO bike) {
        try {
            BikeDTO updatedBike = bikesService.update(id, bike);
            return new ResponseEntity<>(updatedBike, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }  
    }
    @DeleteMapping("/bikes/{id}")
    public ResponseEntity<HttpStatus> deleteBike(@PathVariable("id") String id) {
        try {
            bikesService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/bikes")
    public ResponseEntity<HttpStatus> deleteAllBikes() {
        try {
            bikesService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bikes/available")
    public ResponseEntity<List<BikeDTO>> findByAvailableState() {
        try {
            List<BikeDTO> bikes = bikesService.getAvailableBikes();
            return new ResponseEntity<>(bikes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/bikes/not-available")
    public ResponseEntity<List<BikeDTO>> findByNotAvailableState() {
        try {
            List<BikeDTO> bikes = bikesService.getNotAvailableBikes();
            return new ResponseEntity<>(bikes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
