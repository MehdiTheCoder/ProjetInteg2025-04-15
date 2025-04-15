package com.dailyride.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rentals")
public class Rental {
    @Id
    private String id;
    
    private String carId;
    private String userId;
    private String ownerId;
    
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double totalPrice;
    
    private String status; // "PENDING", "APPROVED", "ONGOING", "COMPLETED", "CANCELLED"
    private String paymentStatus; // "PENDING", "PAID", "REFUNDED"
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Additional rental details
    private String pickupLocation;
    private String dropoffLocation;
    private String specialRequests;
    
    // Review details (after rental)
    private Integer rating;
    private String review;
    
    // Insurance and damage details
    private String insuranceOption; // "BASIC", "PREMIUM"
    private String damageReport;
} 