package com.mxtc.carrentalproject.service;

import com.mxtc.carrentalproject.DBC.CarsDBC;
import com.mxtc.carrentalproject.DBC.RentsDBC;
import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.models.Rents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * in this class are all the proses to give to the controller the right
 * response from the database.
 */
@Service
public class CarService {
    @Autowired
    @Qualifier("carsDB")
    private CarsDBC cars;

    @Autowired
    @Qualifier("rentsDB")
    private RentsDBC rent;

    public Rents getRentById(int id){
        return  this.rent.getRentById(id);
    }

    public Rents insertRent(Rents newRent){
        return this.rent.insertRent(newRent);
    }

    public void cancelOrReturnRent(int id){
        this.rent.cancelRent(id);
    }

    public void updateRent(Rents newChange){
        rent.updateRent(newChange);
    }

    public List<Car> availableCars(String start, String end, String type, String order, boolean asc){//RequiredParameters parameters) {
        //Timestamp start = Timestamp.valueOf(parameters.getStart());
        //Timestamp end = Timestamp.valueOf(parameters.getEnd());
        List<Rents> notAvailable = rent.getUnavailableCars(start, end);
        List<Car> AvailableCars = cars.getAvailableCars(notAvailable, type, order, asc);
        return AvailableCars;
    }



}
