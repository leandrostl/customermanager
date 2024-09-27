package dev.leandro.customermanager.application.domain.service;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.port.in.GetCustomerUseCase;
import dev.leandro.customermanager.application.port.out.GetCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetCustomerService implements GetCustomerUseCase {
    private final GetCustomerPort getCustomerPort;

    @Override
    public Optional<Customer> getCustomer(GetCustomerQuery query) {
        if(query.document() != null)
            return getCustomerPort.findCustomer(query.document());
        return getCustomerPort.findCustomer(query.id());
    }
}
