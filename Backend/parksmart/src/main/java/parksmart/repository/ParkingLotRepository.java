package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.ParkingLot;

public interface ParkingLotRepository
        extends JpaRepository<ParkingLot, Integer> {
}