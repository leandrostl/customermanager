package dev.leandro.customermanager.adapters.out.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {

    private final CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Test
    void whenCustomerIsFulfilledShouldConvert() {
        final var customerEntity = new CustomerJpaEntity(1L, "Jenifer", "Lopes", "123.456.789-88", "CPF");
        final var domainModel = mapper.toDomainModel(customerEntity);
        assertAll("Entity object has same properties as domain model",
                () -> assertEquals(customerEntity.getId(), domainModel.id().value()),
                () -> assertEquals(customerEntity.getFirstName(), domainModel.firstName()),
                () -> assertEquals(customerEntity.getLastName(), domainModel.lastName()),
                () -> assertEquals(customerEntity.getDocument(), domainModel.document().code()),
                () -> assertEquals(customerEntity.getDocumentType(), domainModel.document().type().name()));
    }

}