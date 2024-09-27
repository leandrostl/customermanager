package dev.leandro.customermanager.application.port.out;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.domain.model.Document;

import java.util.Optional;

public interface GetCustomerPort {
    Optional<Customer> findCustomer(Document document);
    Optional<Customer> findCustomer(Customer.CustomerId id);
}
