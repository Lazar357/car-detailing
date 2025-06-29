package rs.ac.signidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.signidunum.entity.Customer;
import rs.ac.signidunum.repo.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findByDeletedAtIsNull();
    }
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findByIdAndDeletedAtIsNull(id);
    }

    public Customer createCustomer(Customer model){
        Customer customer = new Customer();
        customer.setName(model.getName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Integer id, Customer model){
        Customer customer = getCustomerById(id).orElseThrow();
        customer.setName(model.getName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setUpdatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        Customer customer = getCustomerById(id).orElseThrow();
        customer.setDeletedAt(LocalDateTime.now());
        customerRepository.save(customer);
    }

}
