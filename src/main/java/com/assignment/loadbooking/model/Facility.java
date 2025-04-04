package com.assignment.loadbooking.model;

import java.sql.Timestamp;

import jakarta.persistence.Embeddable;
import lombok.Data;
@Embeddable
@Data
public class Facility {

	private String loadingPoint;
    private String unloadingPoint;
    private Timestamp loadingDate;
    private Timestamp unloadingDate;
}
