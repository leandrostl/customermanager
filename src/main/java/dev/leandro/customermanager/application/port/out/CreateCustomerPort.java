package dev.leandro.customermanager.application.port.out;

import dev.leandro.customermanager.application.domain.model.Customer;

public interface CreateCustomerPort {
    Customer save(Customer customer);
}
