package rs.ac.signidunum.controller;

import org.springframework.web.bind.annotation.*;
import rs.ac.signidunum.model.Booking;
import rs.ac.signidunum.repo.BookingRepository;
import rs.ac.signidunum.repo.CustomerRepository;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;

    public BookingController(BookingRepository bookingRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        customerRepository.save(booking.getCustomer());
        return bookingRepository.save(booking);
    }
}
