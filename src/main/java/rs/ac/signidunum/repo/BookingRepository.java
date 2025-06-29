package rs.ac.signidunum.repo;

import org.springframework.stereotype.Repository;
import rs.ac.signidunum.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.signidunum.entity.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByDeletedAtIsNull();
    Optional<Booking> findByIdAndDeletedAtIsNull(Integer id);
    Boolean existsByIdAndDeletedAtIsNull(Integer id);
}
