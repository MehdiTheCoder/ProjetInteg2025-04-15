package com.dailyride.repository;

import com.dailyride.model.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
    List<Rental> findByUserId(String userId);
    List<Rental> findByOwnerId(String ownerId);
    List<Rental> findByCarId(String carId);
    List<Rental> findByStatus(String status);
    List<Rental> findByPaymentStatus(String paymentStatus);
    List<Rental> findByStartDateBetween(LocalDateTime start, LocalDateTime end);
    List<Rental> findByUserIdAndStatus(String userId, String status);
    List<Rental> findByOwnerIdAndStatus(String ownerId, String status);
} 