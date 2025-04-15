package com.dailyride.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    
    private Double amount;
    private String status; // "PENDING", "COMPLETED", "FAILED", "REFUNDED"
    private String paymentMethod; // "CARD", "CASH", "MOBILE_MONEY"
    
    @DBRef
    private Booking booking;
    
    private String transactionId;
    private String paymentDetails;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 