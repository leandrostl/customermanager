package dev.leandro.customermanager.application.port.out;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.domain.model.Document;

import java.util.Optional;

public interface GetCustomerPort {
    Optional<Customer> find(Document document);
    Optional<Customer> find(Customer.CustomerId id);
}
