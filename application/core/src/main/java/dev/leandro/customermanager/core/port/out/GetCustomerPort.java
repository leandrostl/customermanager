package dev.leandro.customermanager.core.port.out;

import dev.leandro.customermanager.core.domain.Customer;
import dev.leandro.customermanager.core.domain.Document;

import java.util.Optional;

public interface GetCustomerPort {
    Optional<Customer> find(Document document);
    Optional<Customer> find(Customer.CustomerId id);
}
