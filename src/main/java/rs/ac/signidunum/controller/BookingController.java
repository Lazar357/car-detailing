package rs.ac.signidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rs.ac.signidunum.entity.Booking;
import rs.ac.signidunum.repo.BookingRepository;
import rs.ac.signidunum.repo.CustomerRepository;
import rs.ac.signidunum.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;


    @GetMapping
    public List<Booking> getAllBookings(){
        return service.getAllBookings();
    }
    @PostMapping
    public Booking saveBooking(@RequestBody Booking model){
        return service.createBooking(model);
    }
    @PutMapping
    public Booking updateBooking(@PathVariable Integer id,@RequestBody Booking model){
        return service.updateBooking(id, model);
    }
    @DeleteMapping
    public void deleteBooking(@PathVariable Integer id){
        service.deleteBooking(id);
    }
}
