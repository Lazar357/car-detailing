package rs.ac.signidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.signidunum.entity.Booking;
import rs.ac.signidunum.repo.BookingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repository;

    public List<Booking> getAllBookings() {
        return repository.findByDeletedAtIsNull();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Booking createBooking(Booking model) {
        Booking booking = new Booking();
        booking.setDate(model.getDate());
        booking.setCustomer(model.getCustomer());
        booking.setTime(model.getTime());
        booking.setService(model.getService());
        booking.setCreatedAt(LocalDateTime.now());
        return repository.save(booking);
    }

    public Booking updateBooking(Integer id, Booking model) {
        Booking booking = getBookingById(id).orElseThrow();
        booking.setDate(model.getDate());
        booking.setCustomer(model.getCustomer());
        booking.setTime(model.getTime());
        booking.setService(model.getService());
        booking.setUpdatedAt(model.getUpdatedAt());
        return repository.save(booking);
    }

    public void deleteBooking(Integer id) {
        Booking booking = getBookingById(id).orElseThrow();
        booking.setDeletedAt(LocalDateTime.now());
        repository.save(booking);
    }

}
