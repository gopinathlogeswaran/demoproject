package com.app.tcskhoj.controller;

import com.app.tcskhoj.entity.Location;
import com.app.tcskhoj.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationRestController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/location/name/{name}")
    public ResponseEntity<Location> getLocationByName(@PathVariable String name) {
        Location location = locationRepository.findByName(name);
        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }

    /**
     * 
     * @param city
     * @return
     */
    @GetMapping("/location/city/{city}")
    public ResponseEntity<Location> getLocationByCity(@PathVariable String city) {
        Location employee = locationRepository.findByCity(city);
        return new ResponseEntity<Location>(employee, HttpStatus.OK);
    }

}
