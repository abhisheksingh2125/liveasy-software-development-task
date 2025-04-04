package com.assignment.loadbooking.controller;

import com.assignment.loadbooking.entity.BookingStatus;
import com.assignment.loadbooking.model.Booking;
import com.assignment.loadbooking.service.IBookingService;
import com.assignment.loadbooking.service.impl.BookingService;
import com.assignment.loadbooking.service.impl.LoadService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
        
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        try {
            Booking savedBooking = bookingService.createBooking(booking);
            return ResponseEntity.ok(savedBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build(); 
        }
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable UUID bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable UUID bookingId, @RequestBody Booking updatedBooking) {
        return ResponseEntity.ok(bookingService.updateBooking(bookingId, updatedBooking));
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable UUID bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}
