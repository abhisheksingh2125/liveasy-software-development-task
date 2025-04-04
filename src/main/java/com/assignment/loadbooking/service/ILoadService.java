package com.assignment.loadbooking.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.assignment.loadbooking.model.Load;

public interface ILoadService {
	Load createLoad(Load load);
	List<Load> fetchLoad(String shipperId, String truckType);
	Optional<Load> getLoadById(UUID id);
	Load updateLoad(UUID id,Load load);
	void deleteLoad(UUID id);
}
