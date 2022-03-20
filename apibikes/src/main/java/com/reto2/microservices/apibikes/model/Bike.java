package com.reto2.microservices.apibikes.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    @NotBlank(message = "Brand is required")
    private String brand;
    @NotBlank(message = "Type is required")
    private String type;
    @NotBlank(message = "Color is required")
    private String color;
    @NotBlank(message = "State is required")
    private Boolean state;

    public Bike(String brand, String type, String color, boolean state) {
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.state = state;
    }

    public boolean isAvailable() {
        return state;
    }

}
