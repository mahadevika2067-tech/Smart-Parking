package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.ParkingSlot;

import java.util.List;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {

    List<ParkingSlot> findByParkingId(int parkingId);
}