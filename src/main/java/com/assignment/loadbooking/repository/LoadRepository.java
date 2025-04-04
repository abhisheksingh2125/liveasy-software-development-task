package com.assignment.loadbooking.repository;

import com.assignment.loadbooking.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {
	
	List<Load> findByShipperIdAndTruckType(String ShipperId, String truckType);
}
