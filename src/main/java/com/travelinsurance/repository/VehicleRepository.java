package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
