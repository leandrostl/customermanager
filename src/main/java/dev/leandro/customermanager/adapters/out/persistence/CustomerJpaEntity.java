package dev.leandro.customermanager.adapters.out.persistence;

import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.domain.model.Document;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "customer",
        uniqueConstraints = @UniqueConstraint(columnNames = {"document"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String documentType;

    public Customer toDomainModel() {
        return new Customer(new Customer.CustomerId(id), firstName, lastName,
                new Document(document, Document.DocumentType.valueOf(documentType)));
    }
}
