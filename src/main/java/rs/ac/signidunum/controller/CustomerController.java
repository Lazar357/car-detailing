package rs.ac.signidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.signidunum.entity.Customer;
import rs.ac.signidunum.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getCustomers();
    }

    @GetMapping
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.of(service.getCustomerById(id));
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer model){
        return service.createCustomer(model);
    }
    @PutMapping
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer model){
        return service.updateCustomer(id, model);
    }

    @DeleteMapping
    public void deleteCustomer(@PathVariable Integer id){
        service.deleteCustomer(id);
    }
}
