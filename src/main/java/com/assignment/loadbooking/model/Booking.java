package com.assignment.loadbooking.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import com.assignment.loadbooking.entity.BookingStatus;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "shipper_id")
    private String shipperId;

    
    private UUID loadId;
    
    private String transporterId;
    private double proposedRate;
    private String comment;
    
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;
    
    @CreationTimestamp
    private Timestamp requestedAt;
}