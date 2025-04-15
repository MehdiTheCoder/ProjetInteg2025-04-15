package com.dailyride.controller;

import com.dailyride.model.Car;
import com.dailyride.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/test/cars")
@RequiredArgsConstructor
public class TestCarController {
    
    private final CarService carService;

    @PostMapping("/add-sample")
    public ResponseEntity<Car> addSampleCar() {
        Car car = Car.builder()
                .brand("Toyota")
                .model("Camry")
                .year(2022)
                .pricePerDay(50.0)
                .location("New York")
                .description("Well maintained sedan, perfect for city driving")
                .transmission("AUTOMATIC")
                .fuelType("GASOLINE")
                .seats(5)
                .features(Arrays.asList("AC", "GPS", "Bluetooth"))
                .available(true)
                .licensePlate("ABC123")
                .insuranceInfo("Full coverage")
                .status("AVAILABLE")
                .build();
        
        return ResponseEntity.ok(carService.addCar(car));
    }

    @PostMapping("/add-luxury")
    public ResponseEntity<Car> addLuxuryCar() {
        Car car = Car.builder()
                .brand("Mercedes")
                .model("S-Class")
                .year(2023)
                .pricePerDay(200.0)
                .location("Manhattan")
                .description("Luxury sedan with premium features")
                .transmission("AUTOMATIC")
                .fuelType("GASOLINE")
                .seats(5)
                .features(Arrays.asList("AC", "GPS", "Bluetooth", "Leather Seats", "Sunroof"))
                .available(true)
                .licensePlate("LUX789")
                .insuranceInfo("Premium coverage")
                .status("AVAILABLE")
                .build();
        
        return ResponseEntity.ok(carService.addCar(car));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Car>> listAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Car>> listAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }
} 