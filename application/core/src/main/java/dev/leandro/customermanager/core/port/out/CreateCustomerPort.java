package dev.leandro.customermanager.core.port.out;

import dev.leandro.customermanager.core.domain.Customer;

public interface CreateCustomerPort {
    Customer save(Customer customer);
}
