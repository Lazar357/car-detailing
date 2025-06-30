package rs.ac.signidunum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.signidunum.dto.BookingRequest;
import rs.ac.signidunum.entity.Booking;
import rs.ac.signidunum.exception.ConflictException;
import rs.ac.signidunum.exception.ResourceNotFoundException;
import rs.ac.signidunum.service.BookingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingRequest request) {
        try {
            Booking created = bookingService.createBooking(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ConflictException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Integer id, @Valid @RequestBody BookingRequest request) {
        try {
            Booking updated = bookingService.updateBooking(id, request);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ConflictException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}