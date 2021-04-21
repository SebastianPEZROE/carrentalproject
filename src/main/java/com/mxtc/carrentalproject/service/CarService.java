package com.mxtc.carrentalproject.service;

import com.mxtc.carrentalproject.DBC.carsdbc;
import com.mxtc.carrentalproject.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    @Qualifier("mysql")
    private carsdbc cars;

    public List<Car> getCars(){
        //List<Car> g = new ArrayList<Car>();
        //g.add(new Car("cheyene",2,true,500));
        return this.cars.getAllCars();
    }



}
