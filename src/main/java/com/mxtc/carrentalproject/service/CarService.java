package com.mxtc.carrentalproject.service;

import com.mxtc.carrentalproject.DBC.carsdbc;
import com.mxtc.carrentalproject.DBC.rentsdbc;
import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.models.RequiredParameters;
import com.mxtc.carrentalproject.models.rents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * in this class are all the proses to give to the controller the right
 * response from the database.
 */
@Service
public class CarService {
    @Autowired
    @Qualifier("carsDB")
    private carsdbc cars;

    @Autowired
    @Qualifier("rentsDB")
    private rentsdbc rent;

    public List<Car> getCars(){
        return this.cars.getAllCars();
    }


    public List<rents> getAllRents(){
        return this.rent.getAllRents();
    }

    public rents getRentById(int id){
        return  this.rent.getRentById(id);
    }

    public rents insertRent(rents newRent){
        return this.rent.insertRent(newRent);
    }

    public void removeRent( int id){
        rent.deleteRent(id);
    }

    public void updateRent(rents newChange){
        rent.updateRent(newChange);
    }

    public List<Car> availableCars(RequiredParameters parameters) {
        Timestamp start = Timestamp.valueOf(parameters.getStart());
        Timestamp end = Timestamp.valueOf(parameters.getEnd());
        List<rents> notAvailable = rent.getUnavailableCars(start, end);
        List<Car> AvailableCars = cars.getAvailableCars(notAvailable);
        return AvailableCars;
    }



}
