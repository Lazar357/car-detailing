package rs.ac.signidunum.repo;

import rs.ac.signidunum.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
