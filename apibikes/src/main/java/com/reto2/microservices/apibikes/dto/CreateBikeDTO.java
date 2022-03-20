package com.reto2.microservices.apibikes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBikeDTO {
    private String brand;
    private String type;
    private String color;
}