package dev.leandro.customermanager.adapters.out.persistence;

import org.junit.jupiter.api.Test;

import static dev.leandro.customermanager.application.domain.model.Document.DocumentType.CPF;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerJpaEntityTest {

    @Test
    void toDomainModel() {
        final var customerJpaEntity = new CustomerJpaEntity(123L, "José", "Ramirez", "123.456.789-88", "CPF");
        final var customer = customerJpaEntity.toDomainModel();
        assertEquals("José", customer.firstName());
        assertEquals("Ramirez", customer.lastName());
        assertEquals(123L, customer.id().value());
        assertEquals("123.456.789-88", customer.document().code());
        assertEquals(CPF, customer.document().type());
    }
}