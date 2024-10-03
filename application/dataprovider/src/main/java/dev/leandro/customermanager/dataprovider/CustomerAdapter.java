package dev.leandro.customermanager.dataprovider;

import dev.leandro.customermanager.core.domain.Customer;
import dev.leandro.customermanager.core.domain.Document;
import dev.leandro.customermanager.core.port.out.CreateCustomerPort;
import dev.leandro.customermanager.core.port.out.GetCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerAdapter implements GetCustomerPort, CreateCustomerPort {
    private final CustomerRepository customerRepository;
    private final CustomerJpaDomainMapper customerMapper;

    @Override
    public Optional<Customer> find(Document document) {
        return customerRepository.findByDocument(document.code()).map(customerMapper::toDomainModel);
    }

    @Override
    public Optional<Customer> find(Customer.CustomerId id) {
        return customerRepository.findById(id.value()).map(customerMapper::toDomainModel);
    }

    @Override
    public Customer save(Customer customer) {
        final var entity = customerMapper.toJpaEntity(customer);
        CustomerJpaEntity created = customerRepository.save(entity);
        return customerMapper.toDomainModel(created);
    }
}
