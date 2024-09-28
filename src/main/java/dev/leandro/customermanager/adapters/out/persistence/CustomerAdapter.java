package dev.leandro.customermanager.adapters.out.persistence;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.domain.model.Document;
import dev.leandro.customermanager.application.port.out.GetCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerAdapter implements GetCustomerPort {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<Customer> findCustomer(Document document) {
        return customerRepository.findByDocument(document.code()).map(customerMapper::toDomainModel);
    }

    @Override
    public Optional<Customer> findCustomer(Customer.CustomerId id) {
        return customerRepository.findById(id.value()).map(customerMapper::toDomainModel);
    }
}
