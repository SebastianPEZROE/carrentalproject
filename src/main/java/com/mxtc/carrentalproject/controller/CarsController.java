package com.mxtc.carrentalproject.controller;

import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "carsAvailable/")
public class CarsController {
    private CarService cs;

    @Autowired
    public CarsController(CarService cs) {
        this.cs = cs;
    }

    @GetMapping
    public List<Car> getAllCars(){
        return cs.getCars();
    }
}
