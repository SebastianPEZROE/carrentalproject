package com.mxtc.carrentalproject.service;

import com.mxtc.carrentalproject.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    public List<Car> getCars(){
        List<Car> g = new ArrayList<Car>();
        g.add(new Car("cheyene",2,true,500));
        return g;
    }



}
