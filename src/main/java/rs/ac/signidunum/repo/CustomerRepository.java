package rs.ac.signidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.signidunum.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByDeletedAtIsNull();
    Optional<Customer> findByIdAndDeletedAtIsNull(Integer id);
    boolean existsByEmailAndDeletedAtIsNull(String email);
    Optional<Customer> findByPhone(String phone);


}