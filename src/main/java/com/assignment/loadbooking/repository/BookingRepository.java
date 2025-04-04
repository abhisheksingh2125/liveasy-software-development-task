package com.assignment.loadbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.loadbooking.model.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> 
{
    List<Booking> findByShipperIdAndTransporterId(String shipperId, String transporterId);

}