package com.dailyride.repository;

import com.dailyride.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByLocation(String location);
    List<Car> findByOwnerId(String ownerId);
    List<Car> findByAvailableTrue();
    List<Car> findByPricePerDayBetween(Double minPrice, Double maxPrice);
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByYearBetween(Integer startYear, Integer endYear);
} 