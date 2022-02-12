package com.starwars.controller;

import com.starwars.model.Vehicle;
import com.starwars.service.VehicleService;
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
    public Flux<Vehicle.Root> getVehicles(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "") String page
    ) {
        return vehicleService.getVehicles(search, page);
    }

    @GetMapping("/{id}")
    public Flux<Vehicle> getVehicleById(@PathVariable("id") String id) {
        return vehicleService.getVehicleById(id);
    }
}
