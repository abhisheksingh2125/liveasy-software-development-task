package com.assignment.loadbooking.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.assignment.loadbooking.model.Booking;
import com.assignment.loadbooking.repository.BookingRepository;
import com.assignment.loadbooking.service.IBookingService;

@Service
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(UUID bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(UUID bookingId, Booking updatedBooking) {
        return bookingRepository.findById(bookingId)
                .map(existingBooking -> {
                    existingBooking.setStatus(updatedBooking.getStatus());
                    return bookingRepository.save(existingBooking);
                })
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
