package com.assignment.loadbooking.service;

import com.assignment.loadbooking.model.Booking;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBookingService {
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(UUID bookingId); 
    Booking createBooking(Booking booking);
    Booking updateBooking(UUID bookingId, Booking updatedBooking);
    void deleteBooking(UUID bookingId);
}
