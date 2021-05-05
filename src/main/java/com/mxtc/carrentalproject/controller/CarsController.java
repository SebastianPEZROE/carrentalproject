package com.mxtc.carrentalproject.controller;

import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this class is use to give and receive the http responses and requests that
 * are related with showing the cars.
 *
 */
@RestController
@RequestMapping(path = "CarRentalSystem/")
public class CarsController {
    private CarService cs;

    @Autowired
    public CarsController(CarService cs) {
        this.cs = cs;
    }

    @GetMapping("/available")
    public List<Car> allAvailableCars(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
                                         @RequestParam(value = "type") String type, @RequestParam(value = "order") String order,
                                         @RequestParam(value= "asc") boolean asc){//@RequestBody RequiredParameters parameters){
        return cs.availableCars(start, end, type, order, asc);
    }

}
