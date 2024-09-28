package dev.leandro.customermanager.application.domain.service;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.port.in.CreateCustomerUseCase;
import dev.leandro.customermanager.application.port.in.GetCustomerUseCase;
import dev.leandro.customermanager.application.port.out.CreateCustomerPort;
import dev.leandro.customermanager.application.port.out.GetCustomerPort;
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
