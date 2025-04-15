package com.dailyride.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;
    
    private String status; // "PENDING", "CONFIRMED", "CANCELLED", "COMPLETED"
    
    @DBRef
    private User passenger;
    
    @DBRef
    private Trip trip;
    
    @DBRef
    private Payment payment;
    
    private Integer numberOfSeats;
    private String specialRequests;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 