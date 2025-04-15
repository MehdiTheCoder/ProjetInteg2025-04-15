package com.dailyride.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "trips")
public class Trip {
    @Id
    private String id;
    
    private String startLocation;
    private String endLocation;
    private LocalDateTime departureTime;
    private Double price;
    private String status; // "SCHEDULED", "IN_PROGRESS", "COMPLETED", "CANCELLED"
    
    @DBRef
    private User driver;
    
    @DBRef
    private List<Booking> bookings;
    
    private Integer availableSeats;
    private String vehicleDetails;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 