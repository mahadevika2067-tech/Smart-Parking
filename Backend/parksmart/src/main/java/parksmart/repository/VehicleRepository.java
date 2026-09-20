package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}