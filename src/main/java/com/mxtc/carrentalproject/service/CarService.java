package com.mxtc.carrentalproject.service;

import com.mxtc.carrentalproject.DBC.CarsDBC;
import com.mxtc.carrentalproject.DBC.RentsDBC;
import com.mxtc.carrentalproject.models.Car;
import com.mxtc.carrentalproject.models.Rents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<Car> availableCars(String start, String end, String type, String order, boolean asc){
        LocalDateTime startDateTime = LocalDateTime.parse(start);
        LocalDateTime endDateTime = LocalDateTime.parse(end);
        if(startDateTime.isAfter(endDateTime))
            return new ArrayList<Car>();
        int hours = getPeriod(startDateTime, endDateTime);
        List<Rents> notAvailable = rent.getUnavailableCars(start, end);
        List<Car> AvailableCars = cars.getAvailableCars(notAvailable, type, order, asc);
        List<Car> availableCarsWithTotalPrice = setTotalPriceToEachCar(AvailableCars, hours);
        return availableCarsWithTotalPrice;
    }

    private int getPeriod(LocalDateTime start, LocalDateTime end){
        LocalDateTime period = end.minusSeconds(start.getSecond());
        period = period.minusMinutes(start.getMinute());
        period = period.minusHours(start.getHour());
        int years = period.getYear() -start.getYear();
        int months = period.getMonthValue() - start.getMonthValue();
        int days = period.getDayOfMonth() - start.getDayOfMonth();
        int hours = period.getHour() + (days *24) + (months*30*24) + (years*12*30*24);
        return hours;
    }

    private List<Car> setTotalPriceToEachCar(List<Car> cars, int hours){
        List<Car> output = cars;
        for(Car car: output ){
            int totalPrice = (int) (car.getPricePerHour() * hours);
            car.setTotalPrice(totalPrice);
        }
        return output;
    }

}
