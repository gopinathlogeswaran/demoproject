package com.app.tcskhoj.repository;

import com.app.tcskhoj.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {

    Location findByName(String name);

    Location findByCity(String city);

    Location findByState(String state);

    Location findByCountry(String country);
}
