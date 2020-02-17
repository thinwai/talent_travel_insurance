package com.travelinsurance.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelinsurance.dto.Vehicle;
import com.travelinsurance.repository.VehicleRepository;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepository vRepo;

	@Override
	public List<Vehicle> findAllVehicle() {
		// TODO Auto-generated method stub
		return vRepo.findAll();
	}
	

}
