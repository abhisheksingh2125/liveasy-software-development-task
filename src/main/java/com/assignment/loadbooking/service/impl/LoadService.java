	package com.assignment.loadbooking.service.impl;
	import com.assignment.loadbooking.entity.LoadStatus;
	import com.assignment.loadbooking.model.Load;
	import com.assignment.loadbooking.repository.LoadRepository;
	import com.assignment.loadbooking.service.ILoadService;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import java.util.List;
	import java.util.Optional;
	import java.util.UUID;
	
	@Service
	public class LoadService implements ILoadService {
	    
	    @Autowired
	    private LoadRepository loadRepository;
	
		@Override
		public Load createLoad(Load load) {
			load.setStatus(LoadStatus.POSTED);
			Load savedLoad = loadRepository.save(load);
			return savedLoad;
		}
	
		@Override
		public List<Load> fetchLoad(String shipperId, String truckType) {
			List<Load> filteredLoadList = loadRepository.findByShipperIdAndTruckType(shipperId, truckType);
			return filteredLoadList;
		}
	
		@Override
		public Optional<Load> getLoadById(UUID id) {
			return loadRepository.findById(id);
		}
	
		@Override
		public Load updateLoad(UUID id, Load load) {
			Optional<Load> existingLoad = loadRepository.findById(id);
			if(existingLoad.isPresent()) {
				Load updatedLoad = existingLoad.get();
				
				return loadRepository.save(updatedLoad);
				
			}else {
				throw new RuntimeException("Load Id not found "+ id);
			}
		}
	
		@Override
		public void deleteLoad(UUID id) {
			loadRepository.deleteById(id);
			
		}	    
	}