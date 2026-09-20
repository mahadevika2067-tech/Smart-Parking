package parksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parksmart.model.Vehicle;
import parksmart.repository.VehicleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteById(id);
    }
}