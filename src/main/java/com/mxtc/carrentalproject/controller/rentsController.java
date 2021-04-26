package com.mxtc.carrentalproject.controller;

import com.mxtc.carrentalproject.models.rents;
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
public class rentsController {

    @Autowired
    private CarService rs;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public rents getRentById(@PathVariable("id") int id){
        return rs.getRentById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public rents insertRent (@RequestBody rents rent){
        return rs.insertRent(rent);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
        rs.removeRent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateRent(@RequestBody rents rent){
        rs.updateRent(rent);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/returnCar/{id}")
    public ResponseEntity<?> returnCar(@PathVariable("id")int id){
        rs.removeRent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
