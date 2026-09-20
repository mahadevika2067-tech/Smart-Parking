package parksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parksmart.model.ParkingLot;
import parksmart.repository.ParkingLotRepository;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
@CrossOrigin(origins = "*")
public class ParkingLotController {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @GetMapping
    public List<ParkingLot> getAllParking() {
        return parkingLotRepository.findAll();
    }

    @PostMapping
    public ParkingLot addParking(@RequestBody ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @DeleteMapping("/{id}")
    public void deleteParking(@PathVariable int id) {
        parkingLotRepository.deleteById(id);
    }
}