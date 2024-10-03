package dev.leandro.customermanager.core.service;


import dev.leandro.customermanager.core.domain.Customer;
import dev.leandro.customermanager.core.domain.Document;
import lombok.Builder;

import java.util.Optional;

public interface GetCustomerUseCase {
    Optional<Customer> getCustomer(GetCustomerQuery query);

    @Builder
    record GetCustomerQuery(Customer.CustomerId id, Document document) {}
}
