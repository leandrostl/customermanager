package dev.leandro.customermanager.application.port.in;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.domain.model.Document;
import lombok.Builder;

import java.util.Optional;

public interface GetCustomerUseCase {
    Optional<Customer> getCustomer(GetCustomerQuery query);

    @Builder
    record GetCustomerQuery(Customer.CustomerId id, Document document) {}
}
