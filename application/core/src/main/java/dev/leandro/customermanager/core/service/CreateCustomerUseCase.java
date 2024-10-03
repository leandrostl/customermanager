package dev.leandro.customermanager.core.service;

import dev.leandro.customermanager.core.domain.Customer;

public interface CreateCustomerUseCase {
    Customer createCustomer(Customer customer);
}
