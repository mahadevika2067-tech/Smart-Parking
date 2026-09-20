package parksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parksmart.model.Booking;
import parksmart.repository.BookingRepository;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;


    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {

        booking.setStatus("Confirmed");

        return bookingRepository.save(booking);
    }


    @PutMapping("/{id}/extend")
    public Booking extendBooking(
            @PathVariable int id,
            @RequestParam String newEndTime) {

        Booking booking =
                bookingRepository.findById(id).orElse(null);

        if (booking == null) {
            return null;
        }

        booking.setEndTime(newEndTime);

        return bookingRepository.save(booking);
    }

    @PutMapping("/{id}/arrive")
public Booking markArriving(@PathVariable int id) {

    Booking booking = bookingRepository.findById(id).orElse(null);

    if (booking == null) {
        return null;
    }

    booking.setStatus("Arriving");

    return bookingRepository.save(booking);
}

@PutMapping("/{id}/cancel")
public Booking cancelBooking(@PathVariable int id) {

    Booking booking = bookingRepository.findById(id).orElse(null);

    if (booking == null) {
        return null;
    }

    booking.setStatus("Cancelled");

    return bookingRepository.save(booking);
}


    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {

        bookingRepository.deleteById(id);
    }
}