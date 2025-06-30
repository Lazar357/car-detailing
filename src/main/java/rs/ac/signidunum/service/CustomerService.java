package rs.ac.signidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.signidunum.entity.Customer;
import rs.ac.signidunum.exception.ResourceNotFoundException;
import rs.ac.signidunum.repo.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllActiveCustomers() {
        return customerRepository.findByDeletedAtIsNull();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nije nadjen korisnik sa id: " + id));
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        if (customerRepository.existsByEmailAndDeletedAtIsNull(customer.getEmail())) {
            throw new IllegalArgumentException("Korisnik sa ovim email-om vec postoji");
        }
        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Integer id, Customer customerDetails) {
        Customer customer = getCustomerById(id);

        if (!customer.getEmail().equals(customerDetails.getEmail()) &&
                customerRepository.existsByEmailAndDeletedAtIsNull(customerDetails.getEmail())) {
            throw new IllegalArgumentException("Email je vec u upotrebi");
        }

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        customer.setUpdatedAt(LocalDateTime.now());

        return customerRepository.save(customer);
    }

    @Transactional
    public void softDeleteCustomer(Integer id) {
        Customer customer = getCustomerById(id);
        customer.setDeletedAt(LocalDateTime.now());
        customerRepository.save(customer);
    }
}