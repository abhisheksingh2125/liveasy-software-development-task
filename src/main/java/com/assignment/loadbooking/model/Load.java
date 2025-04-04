package com.assignment.loadbooking.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import com.assignment.loadbooking.entity.LoadStatus;
import com.assignment.loadbooking.model.Load;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String shipperId;
    
    @Embedded
    private Facility facility;
    
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    
    @CreationTimestamp
    private Timestamp datePosted;
    
    @Enumerated(EnumType.STRING)
    private LoadStatus status = LoadStatus.POSTED;

}