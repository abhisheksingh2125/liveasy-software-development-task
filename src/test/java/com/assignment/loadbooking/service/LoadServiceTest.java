package com.assignment.loadbooking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.assignment.loadbooking.model.Load;
import com.assignment.loadbooking.repository.LoadRepository;
import com.assignment.loadbooking.service.impl.LoadService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

class LoadServiceTest {

    @Mock
    private LoadRepository loadRepository;

    @InjectMocks
    private LoadService loadService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLoad() {
        Load load = new Load();
        UUID loadId = UUID.randomUUID();
        load.setId(loadId);
        load.setShipperId("123"); // Changed from long to String

        when(loadRepository.save(any(Load.class))).thenReturn(load);

        Load savedLoad = loadService.createLoad(load);

        assertNotNull(savedLoad);
        assertEquals(loadId, savedLoad.getId());
    }

    @Test
    void testGetLoadById() {
        UUID loadId = UUID.randomUUID();
        Load load = new Load();
        load.setId(loadId);

        when(loadRepository.findById(loadId)).thenReturn(Optional.of(load));

        Optional<Load> foundLoad = loadService.getLoadById(loadId);

        assertNotNull(foundLoad);
        assertEquals(loadId, foundLoad.get());
    }
}
