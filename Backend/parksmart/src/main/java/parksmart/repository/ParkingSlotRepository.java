package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.ParkingSlot;

public interface ParkingSlotRepository
        extends JpaRepository<ParkingSlot, Integer> {
}