package com.dailyride.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cars")
public class Car {
    @Id
    private String id;
    
    private String brand;
    private String model;
    private Integer year;
    private Double pricePerDay;
    private String location;
    private String ownerId; // Reference to User
    
    private String description;
    private String transmission; // "MANUAL" or "AUTOMATIC"
    private String fuelType;
    private Integer seats;
    private List<String> features; // ["AC", "GPS", "Bluetooth", etc.]
    private List<String> images;
    
    private boolean available;
    private String licensePlate;
    private String insuranceInfo;
    
    // Car status
    private String status; // "AVAILABLE", "RENTED", "MAINTENANCE"
    private Double rating; // Average rating from reviews
} 