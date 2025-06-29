package rs.ac.signidunum.repo;

import org.springframework.stereotype.Repository;
import rs.ac.signidunum.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByDeletedAtIsNull();
    Optional<Customer> findByIdAndDeletedAtIsNull(Integer id);
    Boolean existsByIdAndDeletedAtIsNull(Integer id);
}
