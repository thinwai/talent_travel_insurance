package com.travelinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelinsurance.dto.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>, PaymentRepositoryCustom{

}
