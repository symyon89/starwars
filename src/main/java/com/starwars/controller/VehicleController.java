package com.starwars.controller;

import com.starwars.model.Vehicle;
import com.starwars.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<Flux<Vehicle.Root>> getVehicles(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return new ResponseEntity<>(vehicleService.getVehicles(search, page), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<Vehicle>> getVehicleById(@PathVariable("id") String id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }
}
