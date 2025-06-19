package rs.ac.signidunum.repo;

import rs.ac.signidunum.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
