package com.dailyride.service;

import com.dailyride.model.Car;
import com.dailyride.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final MongoTemplate mongoTemplate;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    public Car updateCar(String id, Car car) {
        Car existingCar = getCarById(id);
        car.setId(existingCar.getId());
        return carRepository.save(car);
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    public List<Car> getAvailableCars() {
        return carRepository.findByAvailableTrue();
    }

    public List<Car> searchCars(String make, String model, Integer year, Double maxPrice) {
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();

        if (make != null && !make.isEmpty()) {
            criteria.add(Criteria.where("make").regex(make, "i"));
        }
        if (model != null && !model.isEmpty()) {
            criteria.add(Criteria.where("model").regex(model, "i"));
        }
        if (year != null) {
            criteria.add(Criteria.where("year").is(year));
        }
        if (maxPrice != null) {
            criteria.add(Criteria.where("pricePerDay").lte(maxPrice));
        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        return mongoTemplate.find(query, Car.class);
    }
} 