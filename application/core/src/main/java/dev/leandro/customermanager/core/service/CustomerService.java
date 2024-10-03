package dev.leandro.customermanager.core.service;

import dev.leandro.customermanager.core.domain.Customer;
import dev.leandro.customermanager.core.port.out.CreateCustomerPort;
import dev.leandro.customermanager.core.port.out.GetCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements GetCustomerUseCase, CreateCustomerUseCase {
    private final GetCustomerPort getCustomerPort;
    private final CreateCustomerPort createCustomerPort;

    @Override
    public Optional<Customer> getCustomer(GetCustomerQuery query) {
        if(query.document() != null)
            return getCustomerPort.find(query.document());
        return getCustomerPort.find(query.id());
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return createCustomerPort.save(customer);
    }
}