package com.mxtc.carrentalproject.controller;

import com.mxtc.carrentalproject.models.Rents;
import com.mxtc.carrentalproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * this class is use to give and receive the http responses and requests that
 * are related with the rent of a car.
 *
 */
@RestController
@RequestMapping(path = "CarRentalSystem/ScheduleRent")
public class RentsController {

    @Autowired
    private CarService rs;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rents getRentById(@PathVariable("id") int id){
        return rs.getRentById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rents insertRent (@RequestBody Rents rent){
        return rs.insertRent(rent);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<?> cancelReservation(@PathVariable("id") int id){
        rs.cancelOrReturnRent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRent(@RequestBody Rents rent){
        rs.updateRent(rent);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/returnCar/{id}")
    public ResponseEntity<?> returnCar(@PathVariable("id")int id){
        rs.cancelOrReturnRent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
