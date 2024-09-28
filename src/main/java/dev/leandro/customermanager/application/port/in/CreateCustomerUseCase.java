package dev.leandro.customermanager.application.port.in;

import dev.leandro.customermanager.application.domain.model.Customer;

public interface CreateCustomerUseCase {
    Customer createCustomer(Customer customer);
}
