
package parksmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parksmart.model.Booking;

public interface BookingRepository
        extends JpaRepository<Booking, Integer> {
}