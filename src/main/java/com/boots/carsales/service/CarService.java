package com.boots.carsales.service;

import com.boots.carsales.entity.Car;
import com.boots.carsales.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public boolean saveCar(Car car){
        carRepository.save(car);
        return true;
    }

    public boolean deleteCar(Long carId){
        if (carRepository.findById(carId).isPresent()) {
            carRepository.deleteById(carId);
            return true;
        }
        return false;
    }

    public List<Car> allCars() {
        return carRepository.findAll();
    }
}
