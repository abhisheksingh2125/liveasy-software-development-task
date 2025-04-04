package com.assignment.loadbooking.controller;

import com.assignment.loadbooking.model.Load;
import com.assignment.loadbooking.service.ILoadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "Load Management", description = "APIs for managing loads")
@RestController
@RequestMapping("/api/loads") 
public class LoadController {
    private final ILoadService loadService;

    public LoadController(ILoadService loadService) {
        this.loadService = loadService;
    }

    @Operation(summary = "Create Load", description = "Create a new load entry")
    @PostMapping
    public ResponseEntity<Load> createLoad(@Valid @RequestBody Load load) {
        Load savedLoad = loadService.createLoad(load);
        return ResponseEntity.ok(savedLoad);
    }

    @Operation(summary = "Fetch Loads", description = "Fetch all loads filtered by shipper ID and truck type")
    @GetMapping
    public ResponseEntity<List<Load>> fetchLoads(@RequestParam String shipperId, @RequestParam String truckType) {
        List<Load> loads = loadService.fetchLoad(shipperId, truckType);
        return ResponseEntity.ok(loads);
    }

    @Operation(summary = "Get Load by ID", description = "Fetch load details by load ID")
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update Load", description = "Update existing load details")
    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @Valid @RequestBody Load updatedLoad) {
        Load updated = loadService.updateLoad(loadId, updatedLoad);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete Load", description = "Delete a load entry by ID")
    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.noContent().build();
    }
}
