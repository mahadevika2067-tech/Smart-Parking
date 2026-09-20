package parksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parksmart.model.ParkingSlot;
import parksmart.repository.ParkingSlotRepository;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@CrossOrigin(origins = "*")
public class ParkingSlotController {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }

    @GetMapping("/parking/{parkingId}")
    public List<ParkingSlot> getSlotsByParking(@PathVariable int parkingId) {
        return parkingSlotRepository.findByParkingId(parkingId);
    }

    @PostMapping
    public ParkingSlot addSlot(@RequestBody ParkingSlot slot) {
        return parkingSlotRepository.save(slot);
    }

    @DeleteMapping("/{id}")
    public void deleteSlot(@PathVariable int id) {
        parkingSlotRepository.deleteById(id);
    }
    @PutMapping("/{id}")
public ParkingSlot updateSlot(
        @PathVariable int id,
        @RequestBody ParkingSlot updatedSlot) {

    ParkingSlot slot = parkingSlotRepository.findById(id).orElse(null);

    if (slot == null) {
        return null;
    }

    slot.setSlotNumber(updatedSlot.getSlotNumber());
    slot.setStatus(updatedSlot.getStatus());
    slot.setParkingId(updatedSlot.getParkingId());

    return parkingSlotRepository.save(slot);
}
}