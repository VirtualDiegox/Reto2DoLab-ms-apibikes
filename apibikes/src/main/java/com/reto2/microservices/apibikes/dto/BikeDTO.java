package com.reto2.microservices.apibikes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeDTO {
    private String id;
    private String brand;
    private String type;
    private String color;
    private Boolean state;
}
