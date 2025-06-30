package rs.ac.signidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.signidunum.dto.BookingRequest;
import rs.ac.signidunum.entity.Booking;
import rs.ac.signidunum.entity.Customer;
import rs.ac.signidunum.exception.ConflictException;
import rs.ac.signidunum.exception.ResourceNotFoundException;
import rs.ac.signidunum.repo.BookingRepository;
import rs.ac.signidunum.repo.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findByDeletedAtIsNull();
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nije nadjena rezervacija sa id: " + id));
    }

    @Transactional
    public Booking createBooking(BookingRequest request) {
        Customer customer = customerRepository.findByPhone(request.getCustomer().getPhone())
                .orElseGet(() -> {
                    Customer newCustomer = new Customer();
                    newCustomer.setName(request.getCustomer().getName());
                    newCustomer.setPhone(request.getCustomer().getPhone());
                    newCustomer.setEmail(request.getCustomer().getEmail());
                    return customerRepository.save(newCustomer);
                });

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setService(request.getService());
        booking.setDate(request.getDate());
        booking.setTime(request.getTime());
        booking.setVehicle(request.getVehicle());

        return bookingRepository.save(booking);
    }

    @Transactional
    public Booking updateBooking(Integer id, BookingRequest request) {
        Booking booking = getBookingById(id);

        if (!booking.getDate().equals(request.getDate()) || !booking.getTime().equals(request.getTime())) {
            if (bookingRepository.existsByDateAndTime(request.getDate(), request.getTime())) {
                throw new ConflictException("Vec postoji rezervacija u tom vremenu");
            }
        }
        booking.setDate(request.getDate());
        booking.setTime(request.getTime());
        booking.setService(request.getService());
        booking.setUpdatedAt(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Transactional
    public void deleteBooking(Integer id) {
        Booking booking = getBookingById(id);
        booking.setDeletedAt(LocalDateTime.now());
        bookingRepository.save(booking);
    }
}